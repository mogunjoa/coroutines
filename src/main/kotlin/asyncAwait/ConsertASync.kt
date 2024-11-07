package org.example.asyncAwait

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.example.job.getElapsedTime

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 시작 시간 기록

    // 플랫폼 1에서 등록한 관람객 목록 가져오는 코루틴 실행
    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "명수")
    }

    // 플랫폼 2에서 등록한 관람객 목록 가져오는 코루틴 실행
    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("용기", "수지")
    }

    /* 플랫폼 1, 2의 결과 대기를 이렇게 각각 걸어줄수도 있지만 아래 awaitAll 함수를 이용하는게 더 효율적이다.
    val participant1 = participantDeferred1.await() // 플랫폼 1 관람객 목록 결과 수신 대기
    val participant2 = participantDeferred2.await() // 플랫폼 2 관람객 목록 결과 수신 대기

    // 지난 시간 표시 및 참여자 목록 병합 출력
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participant1, *participant2)}")
    */

    // 플랫폼 1, 2 관람객 목록 결과 한번에 수신 대기
    val results = awaitAll(participantDeferred1, participantDeferred2)
//    val results = listOf(participantDeferred1, participantDeferred2).awaitAll() // awaitAll 함수는 Collection에 대한 확장 함수로도 선언되어있다.

    // 지난 시간 표시 및 참여자 목록 병합 출력
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}
