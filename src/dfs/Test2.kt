package dfs

fun main() {

    // 2
    val n = 3
    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))

    // 1
//    val n = 3
//    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))

    println(solution(n, computers))
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val checkMap = Array(n) { false }
    fun dfs(checkNum: Int) {
        if (!checkMap[checkNum]) {
            checkMap[checkNum] = true
            answer++
        }
        computers[checkNum].forEachIndexed { index, value ->
            if (!checkMap[index] && value != 0) {
                checkMap[index] = true
                dfs(index)
            }
        }
    }
    computers.forEachIndexed { computerIndex, computer ->
        dfs(computerIndex)
    }
    return answer
}
