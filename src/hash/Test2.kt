package hash

fun main() {
    val phoneBook = arrayOf("119", "97674223", "1195524421")
//    val phoneBook = arrayOf("123", "456", "789")
//    val phoneBook = arrayOf("12", "123", "1235", "567", "88")
    fun solution(phoneBook: Array<String>): Boolean {
        var answer = true
        run {
            phoneBook.forEachIndexed { tartgetIndex, targetValue ->
                phoneBook.forEachIndexed loop@{ index, value ->
                    if (tartgetIndex == index) {
                        return@loop
                    }
                    if (value.startsWith(targetValue)) {
                        answer = false
                        return@run
                    }
                }
            }
        }
        return answer
    }
    println(solution(phoneBook))
}

