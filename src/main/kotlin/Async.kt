package org.example

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main(){
    runBlocking {
        val firstDeferred = async { getRandom1()}
        val secondDeferred = async { getRandom2()}
        println("doing some processing")
        delay(500L)
        println("waiting for values")
        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()
        println("The total is ${firstValue + secondValue}")
    }
}

suspend fun getRandom1() : Int{
    delay(1000L)
     val value = Random.nextInt(100)
    println("Returning first value $value")
    return value
}
suspend fun getRandom2() : Int{
    delay(2000L)
    val value = Random.nextInt(1000)
    println("Returning second value $value")
    return value
}