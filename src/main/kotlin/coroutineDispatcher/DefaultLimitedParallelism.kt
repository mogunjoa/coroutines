package org.example.coroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatcher.Default의 limitedParallelism
 * Dispatcher.Default의 Cpu 바운드 처리 작업 중 특정 작업의 스레드를 제안하는 기능
 */
fun main() = runBlocking<Unit> {
    val imageProcessingDispatcher = Dispatchers.Default.limitedParallelism(2)
    repeat(100) {
        launch(imageProcessingDispatcher) {
            Thread.sleep(1000L)
            println("[${Thread.currentThread().name}] 이미지 처리 완료")
        }
    }
}