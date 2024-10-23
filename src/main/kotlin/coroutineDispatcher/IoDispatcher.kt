package org.example.coroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 입출력을 위한 Dispatcher
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        launch {
            println("[${Thread.currentThread().name}] 작업 1 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 작업 2 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 작업 3 실행")
        }
    }
}