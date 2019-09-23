package heap

import java.util.*

fun main() {
    val scoville = intArrayOf(1, 2)
    val K = 8
    println("answer : " + solution(scoville, K))
}

private fun solution(scoville: IntArray, K: Int): Int {
    var answer = 0
    val queue = PriorityQueue<Int>()
    scoville.forEach {
        queue.add(it)
    }
    while (queue.size > 1 && queue.peek() < K) {
        val firstValue = queue.poll()
        val secondValue = queue.poll()
        val newScovillValue = firstValue + secondValue * 2
        queue.add(newScovillValue)
        answer++
    }
    if (queue.size >= 1 && queue.peek() < K) {
        answer = -1
    }
    return answer
}