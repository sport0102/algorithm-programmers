package dfs

var count = 0

fun main() {
//    val numbers = intArrayOf(1, 1, 1, 1, 1)
//    val target = 3

    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3
    println(solution(numbers, target))
}

fun solution(numbers: IntArray, target: Int): Int {
    val arraySize = numbers.size
    checkTarget(0, arraySize, numbers[0], numbers, target)
    checkTarget(0, arraySize, -numbers[0], numbers, target)
    return count
}

fun checkTarget(nowIndex: Int, arraySize: Int, sum: Int, originalArray: IntArray, target: Int) {
    if (nowIndex < arraySize - 1) {
        val index = nowIndex + 1
        checkTarget(index, arraySize, sum + originalArray[index], originalArray, target)
        checkTarget(index, arraySize, sum - originalArray[index], originalArray, target)
    } else {
        if (sum == target) count++
    }
}