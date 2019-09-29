package sort

import java.util.*

fun main() {
//    val numbers = intArrayOf(6, 10, 2)
    val numbers = intArrayOf(3, 30, 34, 5, 9)
    println(solution(numbers))
}

fun solution(numbers: IntArray): String {
    var answer = ""
    numbers.sortedWith(Comparator({ num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2") }))
        .forEach { answer += it }
    if ("(0*)".toRegex().replace(answer, "").isEmpty()) {
        answer = "0"
    }
    return answer
}