package org.example.asyncAwait

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * withContext는 코루틴이 유지된 상태로 스레드만 바뀌기 때문에 순차 처리가 된다.
 * 그러므로 병렬처리가 필요할 경우에는 async-await을 이용해야한다.
 */
fun main() = runBlocking<Unit> {
    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값이 반환됩니다.")
        "결과값"
    }

    println("[${Thread.currentThread().name}] 결과값: $result")
    return@runBlocking


    val result1 = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값1이 반환됩니다.")
        "결과값1"
    }

    println("[${Thread.currentThread().name}] 결과값1: $result1")

    val result2 = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값2이 반환됩니다.")
        "결과값2"
    }

    println("[${Thread.currentThread().name}] 결과값2: $result2")

    val results = listOf(result1, result2)
    println("[${Thread.currentThread().name}] $results")
}