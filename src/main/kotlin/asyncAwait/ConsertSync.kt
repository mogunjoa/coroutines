package org.example.asyncAwait

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.example.job.getElapsedTime

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "명수")
    }

    val participant1 = participantDeferred1.await()

    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("용기", "수지")
    }

    val participant2 = participantDeferred2.await()

    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participant1, *participant2)}")
}
