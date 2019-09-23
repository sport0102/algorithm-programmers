package line

import kotlin.math.ceil

fun main(args: Array<String>) {
    val seatCount = readLine()!!.toInt()
    val seatOccupyList = readLine()!!.split(' ').map(String::toInt)
    var maxNonOccupyCount = 0
    var occupyCount = 0
    seatOccupyList.forEach {
        if (it == 0) {
            occupyCount++
        } else {
            if (maxNonOccupyCount < occupyCount) {
                maxNonOccupyCount = occupyCount
            }
            occupyCount = 0
        }
    }
    println(ceil(maxNonOccupyCount.toDouble() / 2).toInt())
}