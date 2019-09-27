package stack

import java.util.*

fun main() {
    val heights = intArrayOf(6, 9, 5, 7, 4)
//    val heights = intArrayOf(3, 9, 9, 3, 5, 7, 2)
//    val heights = intArrayOf(1, 5, 3, 6, 7, 6, 5)
    val answer = solution(heights)
    answer.forEach {
        print("${it} / ")
    }
}

fun solution(heights: IntArray): IntArray {
    val answer = IntArray(heights.size)
    val stack = Stack<Pair<Int, Int>>()
    heights.forEachIndexed { index, value ->
        stack.push(Pair(index, value))
    }
    while (stack.isNotEmpty()) {
        val target = stack.pop()
        answer[target.first] = stack.lastOrNull { it.second > target.second }?.let { it.first + 1 } ?: 0
    }
    return answer
}

// 배열로 푼 경우
//fun solution(heights: IntArray): IntArray {
//    val answer = IntArray(heights.size)
//    for (i in heights.size - 1 downTo 0) {
//        var receivePosition = 0
//        for (j in (i - 1) downTo 0) {
//            if (heights[j] > heights[i]) {
//                receivePosition = j + 1
//                break
//            }
//        }
//        answer[i] = receivePosition
//    }
//    return answer
//}