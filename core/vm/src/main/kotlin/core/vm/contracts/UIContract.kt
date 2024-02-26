package core.vm.contracts

import core.vm.navigation.NavigationEvent

sealed interface UIContract {
    interface Action : UIContract

    interface Event : UIContract {
        val id: String
            get() = java.util.UUID.randomUUID().toString()
    }

    interface Navigation : UIContract {
        val event: NavigationEvent

        val delay: Long
            get() = 0
    }

    interface State : UIContract
}