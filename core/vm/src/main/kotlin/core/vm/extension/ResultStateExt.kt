package core.vm.extension

import core.vm.resource.Message
import core.util.ResultState

inline fun <T : Any?> ResultState<T>.onFailureWithMsg(
    crossinline action: (throwable: Throwable?, errorMsg: Message?) -> Unit
): ResultState<T> {
    if (this is ResultState.Failure) {
//        if (this.errorCode != null) {
//            val message = Message.Builder()
//                .id("error_code_message")
//                .text(this.errorCode!!.asText)
//                .messageType(MessageType.SnackBar.Builder().build())
//                .build()
//
//            action(this.throwable, message)
//        } else {
            action(this.throwable, null)
//        }
    }
    return this
}
