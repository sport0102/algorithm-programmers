package line

import java.util.*

fun main(args: Array<String>) {
    val applicantCount = readLine()!!.toInt()
    val toiletTimeQueue = LinkedList<Pair<Int, Int>>()
    for (i in 0 until applicantCount) {
        val (startTime, endTime) = readLine()!!.split(' ').map(String::toInt)
        toiletTimeQueue.add(Pair(startTime, endTime))
    }
    toiletTimeQueue.sortWith(Comparator { o1: Pair<Int, Int>, o2: Pair<Int, Int> ->
        o1.first - o2.first
    })
    var needToiletCount = 1
    while (!toiletTimeQueue.isEmpty()) {
        val toiletTime = toiletTimeQueue.poll()
        if (toiletTimeQueue.isEmpty()) break
        val compareToiletTime = toiletTimeQueue.peek()
        if (toiletTime.second > compareToiletTime.first) {
            needToiletCount++
        }
    }
    println(needToiletCount)
}