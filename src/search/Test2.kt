package search

import kotlin.math.sqrt

fun main() {
    val numbers = "17"
//    val numbers = "011"
    println(Test2().solution(numbers))
}

class Test2 {

    lateinit var marked: Array<Boolean>
    lateinit var numbers: String
    val set = mutableSetOf<Int>()

    var count = 0

    fun isPrime(number: String): Boolean {
        val n = number.toInt()

        if (n <= 1 || n in set) {
            return false
        }

        for (i in 2..n / 2) {
            if (n % i == 0) {
                return false
            }
        }

        set.add(n)
        return true
    }

    fun search(depth: Int, total: String) {
        if (total != "" && isPrime(total)) {
            count++
        }
        if (depth > numbers.length) {
            return
        }
        for (i in 0 until numbers.length) {
            if (marked[i] == false) {
                marked[i] = true
                search(depth + 1, total + numbers[i])
                marked[i] = false
            }
        }

    }

    fun solution(numbers: String): Int {
        this.numbers = numbers
        marked = Array(numbers.length) { false }
        search(1, "")
        return count
    }
}