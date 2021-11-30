package com.example.kitchen
/* Циклы */

fun main() {
    print("Ввести число:")
    val n = readLine()?.toIntOrNull() ?: return
    println("Ввели число: $n")

    /* Цикл while. Выполняет код внутри себя, пока истинно условие */
    println("Сумма с помощью while: ${calculateSumByWhile(n)}")

    /* Прерывистый цикл до вводимого n числа */
    println("Сумма с помощью while & return: ${calculateSumWhileInfiniteReturn(n)}")

    /* Оператор break. Предназначен для прекращения выполнения цикла */
    println("Сумма с помощью while & break: ${calculateSumWhileInfiniteBreak(n)}")

    printEvenNumber(n) /* следующая операция цикла */

    /* Конструкция do-while. Выполняет код внутри себя,
    пока истинно условие, но отличие от while в том,
    что код выполнится по крайней мере один раз */
    println("Сумма с помощью do-while: ${calculateSumDoWhile(n)}")

    /* Цикл for. Проходит по диапазону значение и выполняет для каждого элемента из диапазона код внутри себя */
    println("Сумма с помощью for: ${calculateSumFor(n)}")

    /* Диапазон и оператор step. Step указывает шаг диапазона */
    printEvenNumberForStep(n)


}

fun calculateSumByWhile(n: Int): Long {
    var sum: Long = 0
    var currentNumber = 0
    while (currentNumber <= n) {
        println("Do $currentNumber while $n")
        sum += currentNumber
        currentNumber++
    }
    return sum
}

fun calculateSumDoWhile(n: Int): Long {
    var sum: Long = 0
    var currentNumber = 0
    do {
        println("Do $currentNumber while $n")
        sum += currentNumber
        currentNumber++
    } while (currentNumber <= n)
    return sum
}


fun calculateSumWhileInfiniteReturn(n: Int): Long {
    var sum: Long = 0
    var currentNumber = 0
    while (true) {
        if (currentNumber > n) return sum
        sum += currentNumber
        currentNumber++
    }
}

fun calculateSumWhileInfiniteBreak(n: Int): Long {
    var sum: Long = 0
    var currentNumber = 0
    while (true) {
        if (currentNumber > n) break
        sum += currentNumber
        currentNumber++
    }
    return sum
}

fun printEvenNumber(n: Int) {
    var currentNumber = 0
    while (currentNumber <= n) {
        val numberBefore = currentNumber
        currentNumber++
        if (numberBefore % 2 == 1) continue /* следующая операция цикла */
        println("continue $numberBefore")
    }
}

fun calculateSumFor(n: Int): Long {
    var sum: Long = 0

    val range = 0..n
    /* Диапазоны и операторы .. (от 0 по n, включая) и until (от 0 до n, не включая).
    Оператор in (указывает, из какого диапазона брать значения) */
    for (currentNumber in range) {
        sum += currentNumber
    }
    return sum
}

fun printEvenNumberForStep(n: Int){
    /* Диапазон и оператор step. Step указывает шаг диапазона */
    // val range = 0..n step 2

    /* Диапазон и оператор downTo. DownTo создаёт диапазон от большего к меньшему */
    val range = n downTo 0 step 2
    for (currentNumber in range){
        println(currentNumber)
    }
}

