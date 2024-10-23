package org.example.job

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 지연 코루틴: 즉시 실행 요청되지 않는 코루틴
 * launch 함수의 start 인자로 CoroutineStart.LAZY를 넘기면 지연 코루틴이 생성된다.
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] lauch 코루틴 지연 실행")
    }
    delay(3000L)
    lazyJob.start() // 코루틴 실행 lazyJob.join()을 호출해도 실행됨 그러나 runBlocking을 일시중단 시킴. 반면 start는 일시중단 시키지 않는다.
}

fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"