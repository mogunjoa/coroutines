package org.example.coroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * CPU 바운드 작업을 위한 디스패처
 * * Cpu 바운드 작업: 이미지, 동영상 처리나 대용량 데이터 변환 같은 끊이지 않고 연산이 필요한 작업
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default) {
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

