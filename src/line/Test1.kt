package line

import java.util.*
import java.util.Collections.max
import java.util.Collections.min

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val timeQueue = LinkedList<Int>()
    for (i in 0 until a) {
        val time = readLine()!!.toInt()
        timeQueue.add(time)
    }
    val consumerTimes = IntArray(b).map { 0 }.toMutableList()
    var index = 0
    var minTotalTime: Int
    while (!timeQueue.isEmpty()) {
        val messageTime = timeQueue.poll()
        minTotalTime = min(consumerTimes)
        run loop@{
            consumerTimes.forEachIndexed { index, consumerTime ->
                if (minTotalTime >= consumerTime) {
                    consumerTimes[index] += messageTime
                    return@loop
                }
            }
        }
        index++
    }
    print(max(consumerTimes))
}