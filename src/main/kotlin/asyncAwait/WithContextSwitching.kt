package org.example.asyncAwait

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * withContext는 코루틴을 유지한체 인자로 받은 CoroutineDispatcher 를 사용해 코루틴의 실행 스레드를 전환하는데 사용
 * -> 람다식을 실행한 후에는 스레드가 다시 이전의 CoroutineDispatcher 을 사용하도록 전환된다.
 */
private val myDispatcher1 = newSingleThreadContext("MyThread1")
private val myDispatcher2 = newSingleThreadContext("MyThread2")

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 코루틴 실행1")

    withContext(myDispatcher1) {
        println("[${Thread.currentThread().name}] 코루틴 실행2")

        withContext(myDispatcher2) {
            println("[${Thread.currentThread().name}] 코루틴 실행3")
        }

        println("[${Thread.currentThread().name}] 코루틴 실행4")
    }

    println("[${Thread.currentThread().name}] 코루틴 실행5")
}