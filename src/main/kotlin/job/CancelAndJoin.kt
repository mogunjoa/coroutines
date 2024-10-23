package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * cancelAndJoin 함수를 사용한 코루틴 순차처리.
 * 코루틴이 취소된 후 실행돼야 하는 코루틴이 있다면, 코루틴을 취소할 때 cancelAndJoin 함수를 사용하면 된다.
 * 취소 요청한 후 취소가 완료될 때까지 호출 코루틴 일시 중단
 */
fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
        // 코루틴이 취소될 수 있는 시점은 **일시 중단 함수(suspending function)**를 통해서만 확인할 수 있다.
        //Thread.sleep(1000L) <- 쓰레드 슬립을 blocking 함수라 취소 확인 시점을 알 수 없다.
        delay(1000L) // delay 함수는 suspending 함수이기 때문에 취소 확인 시점을 알 수 있다.
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin() // longJob 취소 요청 후 취소 완료될 때까지 호출 코루틴 일시 중단
    executeAfterJobCancelled()  // 취소 후 실행돼야 하는 동작
}

fun executeAfterJobCancelled() {
    println("longJob 코루틴 취소 후 실행돼야 하는 동작")
}