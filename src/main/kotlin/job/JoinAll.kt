package org.example.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * joinAll 함수를 이용한 복수의 코루틴 순차 처리
 */
fun main() = runBlocking<Unit> {
    val convertImageJob1 = launch(Dispatchers.IO) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지1 변환 완료")
    }

    val convertImageJob2 = launch(Dispatchers.IO) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지2 변환 완료")
    }

    joinAll(convertImageJob1, convertImageJob2) // 이미지 1,2가 모두 변환될 떄까지 대기

    val uploadImageJob: Job = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지 1,2 업로드")
    }
}

