package org.example.job

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * Job 객체는 코루틴을 추상화한 객체여서 코루틴의 상태를 간접적으로 나타내는 세가지 상태 변수를 외부로 공개한다.
 * isActive: 코루틴이 활성화 되어 있는지 여부. 코루틴이 '실행 중' 상태일때 true이다.
 * isCancelled: 코루틴에 취소가 요청됐는지 여부. cancel 함수가 호출되기만 하면 true를 반환하므로, 취소 중인 상태도 포함한다.
 * isCompleted: 코루틴이 완료 되었는지 여부, 코루틴이 실행 완료 되거나 취소 완료되면 true 반환
 */

fun main() = runBlocking<Unit> {
    // NEW
    val jobNew: Job = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
    }

    // Active(isActive = true)
    val jobActive: Job = launch {
        delay(1000L)
    }

    // Completed(isCompleted = true)
    val jobCompleted: Job = launch {
        delay(1000L)
    }
    jobCompleted.join()

    // Cancelling(isCancelled = true)
    val jobCancelling: Job = launch {
        while (true) {
            // 작업 중
        }
    }
    jobCancelling.cancel()

    // Cancelled(isCancelled = true)
    val jobCancelled: Job = launch {
        while (true) {
            yield()
        }
    }
    jobCancelled.cancelAndJoin()

    printJobState(jobCancelled)
}

fun printJobState(job: Job) {
    println(
        "Job State\n" +
        "isActive >> ${job.isActive}\n" +
        "isCancelled >> ${job.isCancelled}\n" +
        "isCompleted >> ${job.isCompleted}\n"
    )
}