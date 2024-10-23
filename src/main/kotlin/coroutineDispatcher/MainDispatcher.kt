package org.example.coroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatcher.Main
 * 메인 스레드에서의 작업을 위한 디스패처
 * 기본 코루틴 라이브러리에는 구현체가 없다.
 * -> 사용을 위해서는 안드로이드 코루틴 라이브러리 추가 필요
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Main) {
        println("[${Thread.currentThread().name}] 작업 실행")
    }
}