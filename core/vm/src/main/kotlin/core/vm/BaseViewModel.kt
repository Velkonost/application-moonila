package core.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.util.ResultState
import core.vm.contracts.ActionDispatcher
import core.vm.contracts.UIContract
import core.vm.extension.onFailureWithMsg
import core.vm.navigation.NavigationEvent
import core.vm.navigation.RouteNavigator
import core.vm.resource.Message
import core.vm.resource.MessageDeque
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel
<S : UIContract.State, A : UIContract.Action, N : UIContract.Navigation, E : UIContract.Event>(
    val savedStateHandle: SavedStateHandle = SavedStateHandle(),
    private val initialState: S
) : ViewModel(), ActionDispatcher<A>, RouteNavigator, BaseJobContainer {

    //    override var coroutineScope = vmScope
    override var coroutineScope: CoroutineScope = vmScope

    override val error = MutableStateFlow<Throwable?>(null)

    private val vmScope
        get() = viewModelScope

    private val _viewState = MutableStateFlow(initialState)

    val viewState
        get() = _viewState.asStateFlow()

    //    @NativeCoroutinesIgnore
    private val _events by lazy { MutableSharedFlow<E>() }

    val events by lazy { _events.asSharedFlow() }

    //    @NativeCoroutinesIgnore
    private val _navigationEvent = MutableSharedFlow<NavigationEvent>()

    override val navigationEvent: SharedFlow<NavigationEvent>
        get() = _navigationEvent.asSharedFlow()

    protected fun <T : N> emit(navigation: T) {
        vmScope.launch {
            delay(navigation.delay)
            _navigationEvent.emit(navigation.event)
        }
    }

    protected fun emit(event: E) {
        vmScope.launch { _events.emit(event) }
    }

    protected fun emit(newState: S) {
        _viewState.update { newState }
    }

    protected fun emit(message: Message) {
        vmScope.launch { MessageDeque.enqueue(message) }
    }

    protected fun <T> Flow<T>.stateInWhileSubscribed(
        started: SharingStarted = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue: T
    ) = stateIn(viewModelScope, started = started, initialValue = initialValue)

    protected inline infix fun <T> Flow<ResultState<T>>.collectAndProcess(
        crossinline resultProcessing: ResultState<T>.() -> Unit,
    ) {
        launchJob {
            collect { result ->
                with(result) {
                    resultProcessing.invoke(this)

                    onFailureWithMsg { _, message ->
                        message?.let { emit(it) }
                    }
                }
            }
        }
    }

}