package sort

import kotlin.math.max

fun main() {
    //3
    val citations = intArrayOf(3, 0, 6, 1, 5)
    // 2
//    val citations = intArrayOf(22, 42)
    // 3
//    val citations = intArrayOf(20, 19, 18, 1)
    println("answer : ${solution(citations)}")
}

private fun solution(citations: IntArray): Int {
    val result = citations.sortedArrayDescending()
    for (i in 0 until result.size) {
        if (result[i] < i + 1) {
            return i
        }
    }
    return citations.size
}