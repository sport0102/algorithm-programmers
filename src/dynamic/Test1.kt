package dynamic

import java.util.*
import kotlin.math.max

fun main() {
//    val N = 5
//    val number = 12


//    val N = 2
//    val number = 11

//    val N = 4
//    val number = 67

    val N = 5
    val number = 3600
    println(solution(N, number))
}

fun solution(N: Int, number: Int): Int {
    var answer = 1
    if (N == number) return answer
    var leastCommonMultiple = N * number
    while (leastCommonMultiple > N) {
        println("leastCommonMultiple : ${leastCommonMultiple}")
        var checkNum = N
        answer++
        while ("${checkNum}${N}".toInt() <= leastCommonMultiple) {
            checkNum = "${checkNum}${N}".toInt()
            if (number % checkNum == 0) break
            answer++
        }
        println("checkNum : ${checkNum}")
        leastCommonMultiple -= checkNum
    }
    if (leastCommonMultiple > 0) {
        answer++
    }
    println("answer : ${answer}")
    if (answer > 8) answer = -1
    return answer
}

