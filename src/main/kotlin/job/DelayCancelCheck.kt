package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * delay 함수는 특정 시간만큼 코루틴을 일시 중단하게 만든다.
 * -> 일시 중단 시점에 코루틴의 취소가 확인돼 취소된다.
 * 아래 코드 방법은 delay 함수를 사용해 취소를 확인하기 때문에 while 문이 반복될 때마다 일시 중단이 된다.
 * -> 불필요하게 작업을 지연시켜 성능 저하가 일어난다.
 */
fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            delay(1L) // delay 함수는 suspending 함수이기 때문에 취소 확인 시점을 알 수 있다.
        }
    }

    delay(100L)
    whileJob.cancel()
}