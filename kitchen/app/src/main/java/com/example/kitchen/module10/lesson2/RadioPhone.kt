package com.example.kitchen.module10.lesson2

class RadioPhone: CallReceiver {
    override val vendor = "SONY"

    override fun call(number: String) {
        println("radio phone calling $number")
    }
}