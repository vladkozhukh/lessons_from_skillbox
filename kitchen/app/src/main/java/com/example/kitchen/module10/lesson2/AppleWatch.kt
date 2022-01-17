package com.example.kitchen.module10.lesson2

class AppleWatch: Callable {
    override val vendor: String
        get() = "apple"

    override fun call(number: String) {
        println("my watch calling $number")
    }
}