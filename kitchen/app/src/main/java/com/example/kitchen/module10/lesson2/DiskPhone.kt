package com.example.kitchen.module10.lesson2

class DiskPhone: CallReceiver {
    override val vendor = "Panasonic"

    override fun call(number: String) {
        println("Disk phone calling $number")
    }
}