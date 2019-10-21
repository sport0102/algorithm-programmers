package kakao

fun main() {
    println(solution())
}

private fun solution(): String {
//    var word = "abbcccb"
//    val K = 3
//    var word = "aaaaaaaaaaaasssdfffaassdffccksskfflddkffh"
    var word = "sdfdlkh"
    val K = 2

    var answerWord = word
    var beforeChar: Char? = null
    var isModified = true
    var duplicateCount = 1
    var removeStartIndex = 0
    var removeEndIndex: Int
    while (isModified) {
        isModified = false
        run forLoop@{
            answerWord.forEachIndexed { index, c ->
                println("index : ${index}")
                println("c : ${c}")
                println("beforeChar : ${beforeChar}")
                when (beforeChar) {
                    null -> {
                        removeStartIndex = 0
                        duplicateCount = 1
                    }
                    c -> {
                        println("beforeChar == c")
                        duplicateCount++
                        if (K == duplicateCount) {
                            removeEndIndex = index + 1
                            answerWord = answerWord.removeRange(removeStartIndex, removeEndIndex)
                            println("word : ${word}")
                            isModified = true
                            beforeChar = null
                            return@forLoop
                        }
                    }
                    else -> {
                        println("else == else")
                        duplicateCount = 1
                        removeStartIndex = index
                    }
                }
                beforeChar = c
            }
        }
    }
    return answerWord

}