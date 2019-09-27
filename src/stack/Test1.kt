package stack

import java.util.*

fun main() {
//    val priorities = intArrayOf(2, 1, 3, 2)
//    var location = 2

//    val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
//    var location = 0

    val priorities = intArrayOf(2, 5, 18)
    var location = 0

    var answer = 0
    val queue = LinkedList<Int>()
    priorities.forEach {
        queue.add(it)
    }
    do {
        var enablePrint = true
        val checkValue = queue.poll()
        run loop@{
            queue.forEach {
                if (checkValue < it) {
                    enablePrint = false
                    queue.add(checkValue)
                    if (location == 0) {
                        location = queue.size - 1
                    } else {
                        location -= 1
                    }
                    return@loop
                }
            }
        }
        if (enablePrint) {
            answer++
            if (location == 0) {
                break
            }
            location -= 1
        }
    } while (true)
    println(answer)
}