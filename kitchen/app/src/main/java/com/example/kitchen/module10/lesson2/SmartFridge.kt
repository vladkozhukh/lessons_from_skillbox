package com.example.kitchen.module10.lesson2

class SmartFridge: Callable {
    override val vendor = "LG"

    override fun call(number: String) {
        println("hey, smart fridge calling $number")
    }
}