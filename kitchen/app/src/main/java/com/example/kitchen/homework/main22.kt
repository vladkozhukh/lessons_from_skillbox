package com.example.kitchen.homework

fun main() {
    var string = "F2p)v\"y233{0->c}ttelciFc"

    // Вторую половину сообщения обработать так:
    // 3.3. Развернуть получившуюся строку.
    val stringReversed = string.reversed()
    println(stringReversed)
    // 3.2. (сдвиг каждого символа вправо на 4). Делаем обатное
    val shiftedStringLeftFour = stringReversed.map { char -> char - 4 }.joinToString("")
    println(shiftedStringLeftFour)
    // 3.1. Заменить "пробелы" на символ "_". Делаем обратное
    val changeCharString = shiftedStringLeftFour.replace("_", " ")
    println(changeCharString)
    val secondWord = changeCharString.substring(0, changeCharString.length / 2)


    // Обработать первую половину сообщения следующим образом:
    // 2.5. (сдвиг каждого символа влево на 1). Делаем обратное
    val shiftedStringRightOne = string.map { char -> char + 1 }.joinToString("")
    println(shiftedStringRightOne)
    // 2.4. В получившемся тексте заменить все символы s на цифру 5. Обратное
    val changeCharFiveToS = shiftedStringRightOne.replace("5", "s")
    println(changeCharFiveToS)
    // 2.3. В получившемся тексте заменить все символы u на цифру 4. Обатное
    val changeCharFourToU = changeCharFiveToS.replace("4", "u")
    println(changeCharFourToU)
    // 2.2. (сдвиг каждого символа вправо на 3). Обратное
    val shiftedStringLeftThree = changeCharFourToU.map { char -> char - 3 }.joinToString("")
    println(shiftedStringLeftThree)
    // 2.1. В исходном тексте заменить все символы о на символ 0 (ноль). Обратное
    val changeCharZeroToO = shiftedStringLeftThree.replace("0", "o")
    val firstWord = changeCharZeroToO.substring(0, changeCharZeroToO.length / 2)
    val result = """
        $firstWord
        $secondWord
    """.trimIndent()
    println(result)
}