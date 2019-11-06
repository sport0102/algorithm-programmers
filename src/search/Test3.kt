package search

fun main() {
    // 2
    val baseball = arrayOf(intArrayOf(123, 1, 1), intArrayOf(356, 1, 0), intArrayOf(327, 2, 0), intArrayOf(489, 0, 1))
    println(solution(baseball))
}

private fun solution(baseball: Array<IntArray>): Int {

    val answerList = mutableListOf<String>()

    fun checkCase(checkValue: String, baseballValue: String, strike: Int, ball: Int): Boolean {
        val comparedValueStringToArray = checkValue.split("").filter { it.isNotEmpty() }
        val baseballValueStringToArray = baseballValue.split("").filter { it.isNotEmpty() }
        var strikeCount = 0
        var ballCount = 0
        comparedValueStringToArray.forEachIndexed { index, value ->
            when {
                value == baseballValueStringToArray[index] -> {
                    strikeCount++
                }
                baseballValueStringToArray.contains(value) -> {
                    ballCount++
                }
            }
        }
        return strike == strikeCount && ball == ballCount
    }

    for (i in 123..987) {
        val checkValueToString = i.toString()
        if (checkValueToString.contains("0")) continue
        val checkValueStringToArray = checkValueToString.split("").filter { it.isNotEmpty() }.distinct()
        if (checkValueStringToArray.size != 3) continue
        var contain = true
        baseball.forEach {
            if (!checkCase(checkValueToString, it[0].toString(), it[1], it[2])) {
                contain = false
            }
        }
        if (contain) {
            answerList.add(checkValueToString)
        }
    }
    return answerList.size
}