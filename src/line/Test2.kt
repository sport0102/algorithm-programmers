package line

import java.util.*
import java.util.Collections.max
import java.util.Collections.min


fun main(args: Array<String>) {
    val numberList = readLine()!!.split(' ').map(String::toInt).toIntArray()
    val numberListLength = numberList.size
    permutation(numberList, 0, numberListLength, numberListLength)
}

fun permutation(arr: IntArray, depth: Int, n: Int, r: Int) {
    if (depth == r) {
        print(arr, r)
        return
    }

    for (i in depth until n) {
        swap(arr, depth, i)
        permutation(arr, depth + 1, n, r)
        swap(arr, depth, i)
    }
}

fun swap(arr: IntArray, depth: Int, i: Int) {
    if (depth == 0 && arr[i] == 0) return
    val temp = arr[depth]
    arr[depth] = arr[i]
    arr[i] = temp
}

fun print(arr: IntArray, r: Int) {
    for (i in 0 until r)
        print(arr[i].toString() + " ")
    println()
}