package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {
        launch(Dispatchers.Default) {
            println("first context: $coroutineContext")
            withContext(Dispatchers.IO){
                println("second context: $coroutineContext")
            }
            println("third context: $coroutineContext")
        }
    }
}