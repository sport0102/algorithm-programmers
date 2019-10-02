package dynamic

fun main() {
    //26
//    val N = 5
    //42
    val N = 6
    println(solution(N))
}

fun solution(N: Int): Int {
    if (N == 1) {
        return 4
    }
    if (N == 2) {
        return 10
    }
    val numberList = mutableListOf<Int>()
    numberList.add(1)
    numberList.add(1)
    for (i in 2 until N) {
        numberList.add(numberList[i - 2] + numberList[i - 1])
    }
    return (numberList[N - 1] * 2) + ((numberList[N - 2] + numberList[N - 1]) * 2)
}