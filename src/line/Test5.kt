package line

lateinit var map: Array<IntArray>

fun main(args: Array<String>) {
    val (mapMaxX, mapMaxY) = readLine()!!.split(' ').map(String::toInt)
    val (targetX, targetY) = readLine()!!.split(' ').map(String::toInt)
    map = Array(mapMaxY) { IntArray(mapMaxX) }
    val pathMap = Array(mapMaxY) { IntArray(mapMaxX).toMutableList() }
    println(calculatePath(mapMaxY-1, mapMaxX-1))
}

fun calculatePath(m: Int, n: Int): Long {
    println(map[m][n])
    println()
    if (map[0][0] == 0) return 0
    return if (m == 0 && n == 0) 1 else (if (m > 0) calculatePath(m - 1, n) else 0) + if (n > 0) calculatePath(
        m,
        n - 1
    ) else 0
}

