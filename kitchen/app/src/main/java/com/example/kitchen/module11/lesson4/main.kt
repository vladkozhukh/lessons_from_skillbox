package com.example.kitchen.module11.lesson4

// Data class
fun main() {
    val map = mutableMapOf(
        1 to "1",
        2 to "2",
        3 to "3"
    )
    for ((key, value) in map){
        println("key - $key, value - $value")
    }
}