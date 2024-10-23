package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * join 함수를 이용한 순차 처리
 * -> 만약 JobA 코루틴이 완료된 후에 JobB 코루틴이 실행돼야 한다면,
 *    JobB 코루틴이 실행되기 전에 JobA 코루틴에 대해 join 함수를 호출하면 된다.
 */
fun main() = runBlocking<Unit> {
    val updateTokenJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
        delay(100L)
        println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
    }

    updateTokenJob.join() // networkCallJob 실행 전 updateTokenJob.join() 호출

    val networkCallJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }
}