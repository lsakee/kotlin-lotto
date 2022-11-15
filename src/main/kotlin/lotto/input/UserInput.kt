package lotto.input

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Matcher
import java.util.regex.Pattern

fun inputUser(): String {
    val userInputMoney = Console.readLine()
    return userInputMoney.toString()
}



fun inputWinningNumber(): String {
    println("당첨 번호를 입력해 주세요.")
    val userInputNumber = inputUser()
    checkLottoStandard(userInputNumber)
    return userInputNumber
}

fun checkLottoStandard(userInputNumber: String?) {
    userInputNumber ?: throw IllegalArgumentException()
    val checkLotto = userInputNumber.split(",").toList() as MutableList<String>
    for (i in checkLotto)
        if (i.toInt() >= 46 || i.toInt() < 1) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    checkInputMessagePatten(checkLotto)
    if (checkLotto.distinct().size != 6) {
        println("[ERROR]")
        throw IllegalArgumentException()
    }
}

fun checkInputMessagePatten(checkOverlap: MutableList<String>) {
    val regax = "^\\d*$"
    val pattern: Pattern = Pattern.compile(regax)
    for (inputNum in checkOverlap) {
        val matcher: Matcher = pattern.matcher(inputNum)
        if (matcher.find().toString() == "false") {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}

