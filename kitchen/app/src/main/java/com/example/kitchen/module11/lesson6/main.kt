package com.example.kitchen.module11.lesson6

fun main() {

}

// Extensions функции на четность числа Int
//fun Int.isEven(): Boolean {
//    return this % 2 == 0
//}

// имя класса которые расширяем:    Int
// свойство/название для функции:   .isEven()
// ключевое слово доступа: {...     this        условия}

fun printNumber(number: Int) {
//    println(number.isEven())
//    println(5.isEven())
//    number.isEven()
    number.isEven
    5.isEven

}

fun Int.Companion.random(): Int {
    return (System.currentTimeMillis() % 43).toInt()
}

val Int.isEven
    get() = this % 2 == 0
