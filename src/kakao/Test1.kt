package kakao

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.absoluteValue
import kotlin.math.ceil

fun main() {
    solution()
}

private fun solution() {
    val array = intArrayOf(0, 3, 3, 4, 5, 6, 7)
    val generatorMap = HashMap<Int, Int>()
    var needShutDownCount = ceil(array.size / 2.toDouble()).toInt()
    array.forEach {
        if (!generatorMap.containsKey(it)) {
            generatorMap[it] = 1
        } else {
            generatorMap[it] = generatorMap[it]!! + 1
        }
    }
    val generatorCountList = generatorMap.values.sortedDescending().toMutableList()
    var answerCount = 0
    while (needShutDownCount > 0) {
        needShutDownCount -= generatorCountList[0]
        generatorCountList.removeAt(0)
        answerCount++
    }
    println(answerCount)
}