package com.example.kitchen.kotlin
// Expression-выражение.
// Набор значений, переменных, операторов и функций, которые вычисляются для того, чтобы произвести другое значение

// Statement-инструкция.
// Элемент программы, выражающий действия, необходимые для выполнения

import kotlin.random.Random
import kotlin.random.nextInt

fun main() {
    // Цепочка вызовов
    calculateRandomInt()
        .takeIf { it > 2 } /* елси it <= 2 -> it = null */
        ?.let { print("Number > 2") /* если it > 2 -> "текст" */ }
}

fun calculateRandomInt(): Int {
    return Random.nextInt(0 until 10)
}
