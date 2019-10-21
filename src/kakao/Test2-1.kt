package kakao

fun main() {
    println(solution())
}

private fun solution(): String {
    var word = "abbcccb"
    val K = 2
//    var word = "aaaaaaaaaaaasssdfffaassdffccksskfflddkffh"
//    var word = "sdfdlkh"
//    val K = 2

    var answerWord = word
    var beforeChar: Char? = null
    var duplicateCount = 1
    var removeStartIndex = 0
    var removeEndIndex: Int
    val removeIndexList = ArrayList<Pair<Int, Int>>()
    var removeCount : Int
    while (true) {
        answerWord.forEachIndexed { index, c ->
            when (beforeChar) {
                null -> {
                    removeStartIndex = index
                    duplicateCount = 1
                    beforeChar = c
                }
                c -> {
                    duplicateCount++
                    if (K == duplicateCount) {
                        removeEndIndex = index + 1
                        removeIndexList.add(Pair(removeStartIndex, removeEndIndex))
                        beforeChar = null
                    }
                }
                else -> {
                    removeStartIndex = index
                    duplicateCount = 1
                    beforeChar = c
                }
            }
        }
        if (removeIndexList.isNullOrEmpty()) {
            break
        }
        removeCount = 0
        removeIndexList.forEach {
            val startIndex = it.first - K * removeCount
            val endIndex = it.second - K * removeCount
            println("startIndex : ${startIndex}")
            println("endIndex : ${endIndex}")
            answerWord = answerWord.removeRange(startIndex, endIndex)
            println("answerWord : ${answerWord}")
            removeCount++
        }
        removeIndexList.clear()
        beforeChar = null
    }
    return answerWord

}