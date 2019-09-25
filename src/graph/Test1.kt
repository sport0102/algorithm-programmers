package graph

import java.util.*
import java.util.Collections.max
import kotlin.collections.ArrayList

fun main() {
    val n = 6
    val vertex = arrayOf(
        intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4),
        intArrayOf(5, 2)
    )
    println(solution(n, vertex))
}

fun solution(n: Int, edge: Array<IntArray>): Int {
    val graph = Array<ArrayList<Int>>(n + 1) { ArrayList() }
    for (i in 0 until edge.size) {
        val x = edge[i][0]
        val y = edge[i][1]
        graph[x].add(y)
        graph[y].add(x)
    }
    val bfsList = Array(n + 1) { 1 }
    val visitList = Array(n + 1) { false }
    fun bfsSolve() {
        val queue = LinkedList<Int>()
        queue.add(1)
        visitList[1] = true
        while (!queue.isEmpty()) {
            val currentIndex = queue.poll()
            graph[currentIndex].forEach { value ->
                if (!visitList[value]) {
                    visitList[value] = true
                    bfsList[value] = bfsList[currentIndex] + 1
                    queue.add(value)
                }
            }
        }
    }
    bfsSolve()
    val max = max(bfsList.asList())
    return bfsList.filter { it == max }.size
}