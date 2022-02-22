package com.example.kitchen.module13.lesson4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        printWord()
    }

    launch {
        printDots()
    }
    println("Hello ")

}

suspend fun printWord() {
    delay(2000)
    println(" world! ")
}

suspend fun printDots() {
    for (i in 1..500) {
        delay(10)
        if (i % 100 == 0)
            println(".$i")
        else
            print(".$i")
    }
}