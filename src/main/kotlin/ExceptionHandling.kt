package org.example

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        val myHandler = CoroutineExceptionHandler{
            cc, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("Exception inside job")
            throw IndexOutOfBoundsException("exception in coroutine")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("exception from async")
        }

        try {
            deferred.await()
        }catch (e : Exception){
            println(e.localizedMessage)
        }

    }
}
