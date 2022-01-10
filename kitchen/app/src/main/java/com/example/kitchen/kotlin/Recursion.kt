package com.example.kitchen.kotlin
/* Рекурсия */

fun main() {
    print("Ввести число:")
    val n = readLine()?.toIntOrNull() ?: return
    println("Ввели число: $n")

    println(calculateSumRecursive(n))
}

/* Ключевое слово tailrec (хвостовая рекурсия).
Tailrec предназначен, чтобы на уровне jvm из рекурсии сделать цикл */

tailrec fun calculateSumRecursive(n: Int, accum: Int = 0): Int {
    return if (n == 0) {
        accum
    } else {
        // Рекурсия — это вызов функции самой себя
        calculateSumRecursive(n - 1, accum + n)
    }
}