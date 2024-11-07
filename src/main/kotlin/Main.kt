package org.example

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import org.example.job.getElapsedTime
import org.example.job.printJobState
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val coroutineContext1: CoroutineContext = newSingleThreadContext("MyThread1") + CoroutineName("MyCoroutine1")
    val coroutineContext2: CoroutineContext = newSingleThreadContext("MyThread2") + CoroutineName("MyCoroutine2")
    val coroutineContext3: CoroutineContext = Dispatchers.IO

    Job()
    val combinedCoroutineContext: CoroutineContext = coroutineContext1 + coroutineContext2 + coroutineContext3

    launch(context = combinedCoroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }
}