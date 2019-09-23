package hash

import java.util.HashMap

fun main() {
    val participants = listOf("leo", "kiki", "eden")
    val completions = listOf("eden", "kiki")
    var answer = ""
    val checkMap = HashMap<String, Int>()
    completions.forEach {
        if (checkMap[it] == null) {
            checkMap[it] = 0
            println("completions null : ${it} / ${checkMap[it]}")
        } else {
            checkMap[it] = checkMap[it] as Int + 1
            println("completions not null : ${it} / ${checkMap[it]}")
        }
    }
    run loop@{
        participants.forEach {
            println("participants : ${it} / ${checkMap[it]}")
            if (checkMap[it] == null) {
                println("participants null : ${it} / ${checkMap[it]}")
                answer = it
                return@loop
            }
            if (checkMap[it] as Int == 0) {
                checkMap.remove(it)
                return@forEach
            }
            println("participants checkMap[it] not 0 : ${it} / ${checkMap[it]}")
            checkMap[it] = checkMap[it] as Int - 1
        }
    }

    println("answer : ${answer}")
}