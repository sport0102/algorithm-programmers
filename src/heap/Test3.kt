package heap

import java.util.*

fun main() {
    // 9
    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))

//    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(2, 7), intArrayOf(1, 6))

    println(solution(jobs))
}

private fun solution(jobs: Array<IntArray>): Int {
    val jobQueue = LinkedList(jobs.toList())
    var totalTime = 0
    var currentTime = 0
    while (jobQueue.isNotEmpty()) {
        val job = jobQueue.filter { it[0] <= currentTime }.minBy { it[1] }
        println(job.toString())
        if (job == null) {
            currentTime++
            continue
        }
        jobQueue.remove(job)
        currentTime += job[1]
        totalTime += currentTime - job[0]
    }
    return totalTime / jobs.size
}