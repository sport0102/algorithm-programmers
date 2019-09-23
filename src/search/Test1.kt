package search

import java.util.*
import kotlin.math.max

fun main() {
//    val answers = intArrayOf(1, 2, 3, 4, 5)
    val answers = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
//    val answers = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    solution(answers).forEach {
        println(it)
    }
}

private fun solution(answers: IntArray): IntArray {
    val firstPersonWay = intArrayOf(1, 2, 3, 4, 5)
    val secondPersonWay = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val thirdPersonWay = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    val firstPersonWayLength = firstPersonWay.size
    val secondPersonWayLength = secondPersonWay.size
    val thirdPersonWayLength = thirdPersonWay.size
    var firstAnswerCount = 0
    var secondAnswerCount = 0
    var thirdAnswerCount = 0
    answers.forEachIndexed { index, answer ->
        if (answer == firstPersonWay[index % firstPersonWayLength]) firstAnswerCount++
        if (answer == secondPersonWay[index % secondPersonWayLength]) secondAnswerCount++
        if (answer == thirdPersonWay[index % thirdPersonWayLength]) thirdAnswerCount++
    }
    val maxScore = max(firstAnswerCount, max(secondAnswerCount, thirdAnswerCount))
    val list = ArrayList<Int>()
    if (maxScore == firstAnswerCount) list.add(1)
    if (maxScore == secondAnswerCount) list.add(2)
    if (maxScore == thirdAnswerCount) list.add(3)
    return list.stream().mapToInt { it.toInt() }.toArray()
}