package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * delay 함수와 yield 함수 모두 일시중단 후 재개 과정을 거친다.
 * -> 재개 시에는 CoroutineDispatcher에 의해 다시 스레드로 보내지는 과정을 거치기 때문에 비효율적이다.
 * 그렇기에 CoroutineScope의 isActive 확장 프로퍼티를 사용하면 효율적이다.
 *
 * CoroutineScope의 isActive 확장 프로퍼티를 사용한 취소확인
 * -> 코루틴에 취소가 요청되면, CoroutineScope.isActive가 false가 된다.
 */
fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (this.isActive) {
            println("작업 중")
        }
    }

    delay(100L)
    whileJob.cancel()
}