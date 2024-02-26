package core.vm.contracts

fun interface ActionDispatcher<A : UIContract.Action> {
    fun dispatch(action: A)
}