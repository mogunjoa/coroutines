package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * yield란 '양보'라는 뜻으로, yield 함수를 호출한 코루틴은 자신이 사용하던 스레드를 양보한다.
 * -> 스레드를 양보한다는 것은 코루틴이 스레드 사용을 중단하고, 일시 중단 한다는 뜻
 * -> 스데드를 양보한 후 곧바로 재개 요청된다.
 */
fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            yield()
        }
    }

    delay(100L)
    whileJob.cancel()
}