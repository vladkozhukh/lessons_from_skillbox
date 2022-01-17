package com.example.kitchen.module10.lesson4

fun main() {

    // вариант 1 записи АС подсказывает что стоит заменить:
    val evenChecker = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    // вариант 2 записи "lambda", который правильнее прописать:
    val evenChecker2 = IntPredicate { i -> i % 2 == 0 }

    println("i=8 is ${evenChecker.accept(8)}, because i/2=0")
    println("i=9 is ${evenChecker.accept(9)}, because i/2=0")

}

/* если убрать "fun" см. что будет:  */
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}