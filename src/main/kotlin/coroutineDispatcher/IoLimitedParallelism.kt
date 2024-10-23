package org.example.coroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatcher.IO의 limitedParallelism : 입/출력 관련 스레드의 개수를 제한, default와 달리 Dispatcher.IO 내의 스레드가 아닌 공유 스레드풀에서 새로 스레드를 입력 개수만큼 가져와서 이용한다.
 * 다른 작업에 방해 받지 않아야 하는 중요 작업이 있을 경우 사용한다.
 */
fun main() = runBlocking<Unit> {
    val imageProcessingDispatcher = Dispatchers.IO.limitedParallelism(2)
    repeat(100) {
        launch(imageProcessingDispatcher) {
            Thread.sleep(1000L)
            println("[${Thread.currentThread().name}] 이미지 처리 완료")
        }
    }
}