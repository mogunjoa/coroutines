package org.example.coroutineDispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

val singleThreadDispatcher: CoroutineDispatcher = newSingleThreadContext("SignleThread")

fun main() = runBlocking<Unit> {
    launch(singleThreadDispatcher) {
        println("${Thread.currentThread().name} 실행")
    }
}