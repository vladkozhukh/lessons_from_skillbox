package com.example.kitchen

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}") // 4
    println("Third element: ${numbers[2]}") // three
    println("Fourth element: ${numbers[3]}") // four
    println("Index of element \"two\" ${numbers.indexOf("two")}") // 1
}

