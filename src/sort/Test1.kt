package sort

import java.util.*

fun main() {
    val array = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    solution(array, commands).forEach {
        print(it)
    }
}

private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    val answer = IntArray(commands.size)
    commands.forEachIndexed { i, ints ->
        val temp = Arrays.copyOfRange(array, ints[0] - 1, ints[1])
        Arrays.sort(temp)
        answer[i] = temp[ints[2] - 1]
    }
    return answer
}