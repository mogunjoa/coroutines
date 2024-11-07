package org.example.coroutineContext

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}]")
    }

    println("[${coroutineContext[CoroutineName.Key]}]")
}