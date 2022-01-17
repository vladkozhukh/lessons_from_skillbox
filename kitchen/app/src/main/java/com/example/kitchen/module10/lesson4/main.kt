package com.example.kitchen.module10.lesson4

import com.example.kitchen.module10.lesson2.Callable

fun main() {
    val anonymous = object : Callable { /* наследование класса либо интерфейса ":Callable" */
        val name = "name"
        val lastName = "lastName"
        fun method() = println("$name $lastName this method")
        override val vendor = "anonymous object"

        override fun call(number: String) {
            println("print call fun number $number")
        }
    }

    anonymous.name
    anonymous.lastName
    anonymous.method() /* println 1-я строка */

    val aTest = AnonymousTest()
    aTest.methodTest(anonymous)

    val aTestFun = AnonymousTestFun()
    aTestFun.methodTest()
}

class AnonymousTest {
    private val anonymous = object : Callable {
        val name = "name"
        val lastName = "lastName"
        fun method() = println("$name $lastName this method AnonymousTest")
        override val vendor = "anonymous object"

        override fun call(number: String) {
            println("print call fun number $number")
        }
    }

    fun methodTest(obj: Callable) {
        /* не можем обратиться к самому классу пока не пропишем "private" у "val anonymous" */
        anonymous.name
        anonymous.lastName
        anonymous.method() /* println 2-я строка */


        /* можем обратиться только к родителю "класса либо интерфейса" */
        anonymous.vendor
        anonymous.call("anonymous.call")

        obj.vendor                   /* обращение к полям Callable стр.10 */
        obj.call("obj.call")    /* обращение к полям Callable стр.11 */
        // obj.name -> доступа к самому anonymous объету нет
        // чтобы исправить, есть вариант заменить переменную "private val anonymous" функцией:
        // "private fun createAnonymousObject()"
    }
}

class AnonymousTestFun {
    private fun createAnonymousObject() = object : Callable {
        val name = "name"
        val lastName = "lastName"
        fun method() = println("$name $lastName this method AnonymousTestFun")
        override val vendor = "anonymous object"

        override fun call(number: String) {
            println("print call fun number $number")
        }
    }

    fun methodTest() {
        val obj = createAnonymousObject()
        obj.name
        obj.lastName
        obj.method()

        obj.vendor
        obj.call("AnonymousTestFun")

    }
}