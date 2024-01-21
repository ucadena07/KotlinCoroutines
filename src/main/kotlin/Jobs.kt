package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val job1 = launch {
            //delay(3000L)
            println("Job 1 launch")
            val job2 = launch {
                println("Job 2 Launch")
                delay(3000L)
                println("Job 2 is finishing")
            }
            job2.invokeOnCompletion {
                println("job 2 completed")
            }
            val job3 = launch {
                println("Job 3 Launch")
                delay(3000L)
                println("Job 3 is finishing")
            }
            job3.invokeOnCompletion {
                println("job 3 completed")
            }
        }


        job1.invokeOnCompletion {
            println("job 1 completed")
        }

        delay(500L)
        println("The job will be cancel")
        job1.cancel()
    }
}
