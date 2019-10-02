package greedy

import java.lang.Math.abs
import java.util.*

fun main() {
    //11
    val name = "JAZ"
    // 56
//    val name = "JEROEN"
    // 23
//    val name = "JAN"
    // 0
//    val name = "AAA"
    //4
//    val name = "AAABAAA"
    //6
//    val name = "ABAAAAAAABA"
    //2
//    val name = "AAB"
    //12
//    val name = "AABAAAAAAABBB"
    //5
//    val name = "ZZZ"
    //10
//    val name = "BBBBAAAAAB"
    //12
//    val name = "BBBBAAAABA"
    println(solution(name))
}

var answer = 0
fun solution(name: String): Int {
    val charArray = name.toCharArray()
    val checkList = BooleanArray(name.length) { false }
    joyStickMove(charArray, checkList, 0)
    return answer
}

fun joyStickMove(charArray: CharArray, checkList: BooleanArray, index: Int) {
    if (checkRestListAllA(charArray) || checkListIsAllTrue(checkList)) {
        return
    }
    if (!checkList[index]) {
        calculateJoystickMoveCount(charArray[index])
        checkList[index] = true
        charArray[index] = 'A'
    }
    var nextIndex = calculateNextTarget(charArray, checkList, index)
    if (nextIndex == -100) return
    if (nextIndex > 0) {
        nextIndex = abs(nextIndex)
        if (index < nextIndex) {
            answer += nextIndex - index
        } else {
            answer += (charArray.size - index) + nextIndex
        }
    } else {
        nextIndex = abs(nextIndex)
        if (index < nextIndex) {
            answer += index + charArray.size - nextIndex
        } else {
            answer += index - nextIndex
        }
    }
    joyStickMove(charArray, checkList, nextIndex)
}

fun checkRestListAllA(charArray: CharArray): Boolean = charArray.filter { it == 'A' }.size == charArray.size

fun checkListIsAllTrue(checkList: BooleanArray): Boolean = checkList.filter { it }.size == checkList.size

fun calculateJoystickMoveCount(char: Char) {
    val minimumMinus = abs(65 - char.toByte())
    val maximumMinus = abs(91 - char.toByte())
    answer += if (minimumMinus > maximumMinus) maximumMinus else minimumMinus
}

fun calculateNextTarget(charArray: CharArray, checkList: BooleanArray, index: Int): Int {
    val upWordQueue = LinkedList<Pair<Int, Char>>()
    val downWordQueue = LinkedList<Pair<Int, Char>>()
    if (index < charArray.size - 1) {
        for (i in index + 1 until charArray.size) {
            upWordQueue.add(Pair(i, charArray[i]))
        }
    }
    for (i in 0 until index) {
        upWordQueue.add(Pair(i, charArray[i]))
    }
    if (index > 0) {
        for (i in index - 1 downTo 0) {
            downWordQueue.add(Pair(i, charArray[i]))
        }
    }
    for (i in charArray.size - 1 downTo index + 1) {
        downWordQueue.add(Pair(i, charArray[i]))
    }
    while (upWordQueue.isNotEmpty()) {
        val upWordValue = upWordQueue.poll()
        if (!checkList[upWordValue.first] && upWordValue.second != 'A') {
            return +upWordValue.first
        }
        val downWordValue = downWordQueue.poll()
        if (!checkList[downWordValue.first] && downWordValue.second != 'A') {
            return -downWordValue.first
        }
    }
    return -100
}


//fun solution(name: String): Int {
//    var answer = 0
//    val isStartUpStep = checkStartForward(name)
//    if (checkRestListAllA(name.toCharArray())) {
//        return 0
//    }
//
//    if (isStartUpStep || name[0] == 'A') {
//        println("up step")
//        for (index in 0 until name.length) {
//            answer += calculateJoystickMoveCount(name[index])
//            if (checkRestListAllA(name.toCharArray().sliceArray(index + 1..name.length - 1)) || index == name.length - 1) {
//                break
//            }
//            answer++
//        }
//    } else {
//        answer += calculateJoystickMoveCount(name[0])
//        answer++
//        println("answer : ${answer}")
//        for (index in name.length - 1 downTo 1) {
//            answer += calculateJoystickMoveCount(name[index])
//            if (checkRestListAllA(name.toCharArray().sliceArray(1..index - 1)) || index == 1) {
//                break
//            }
//            answer++
//            println("answer : ${answer}")
//        }
//    }
//
//    return answer
//}
//
//fun checkStartForward(name: String): Boolean {
//    var findFromStartAIndex = 0
//    var findFromEndAIndex = 1
//    for (index in 0 until name.length) {
//        if (name[index] == 'A') {
//            break
//        }
//        findFromStartAIndex++
//    }
//
//    for (index in name.length - 1 downTo 0) {
//        if (name[index] == 'A') {
//            break
//        }
//        findFromEndAIndex++
//    }
//    return findFromStartAIndex >= findFromEndAIndex
//}
//
//fun checkRestListAllA(charArray: CharArray): Boolean = charArray.filter { it == 'A' }.size == charArray.size
//
//fun calculateJoystickMoveCount(char: Char): Int {
//    val minimumMinus = abs(65 - char.toByte())
//    val maximumMinus = abs(91 - char.toByte())
//    return if (minimumMinus > maximumMinus) maximumMinus else minimumMinus
//}