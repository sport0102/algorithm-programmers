package greedy

import java.util.*
import kotlin.math.max

fun main() {
    val n = 5
    val lost = intArrayOf(1, 3, 4)
    val reverse = intArrayOf(3, 4)
    println(solution(n, lost, reverse))
}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = n
    val lostSet = lost.toSet() - reserve.toSet()
    val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet
    lostSet.forEach {
        when {
            reserveSet.contains(it + 1) -> reserveSet.remove(it + 1)
            reserveSet.contains(it - 1) -> reserveSet.remove(it - 1)
            else -> answer--
        }
    }
    return answer
}