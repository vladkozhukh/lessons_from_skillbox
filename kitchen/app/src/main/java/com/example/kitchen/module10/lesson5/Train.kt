package com.example.kitchen.module10.lesson5

class Train(maxWeight: Int) : Transporter(maxWeight) {
    override val capacity = 0

    override fun move() {
        println("Train moving on rails")
    }
}