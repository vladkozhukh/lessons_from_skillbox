package com.example.kitchen.module10.lesson2

interface Callable {
    val vendor: String
        // Refactor -> Change signature (ctrl+F6) /* "+" -> "number: String" */
    fun call(number: String)
}