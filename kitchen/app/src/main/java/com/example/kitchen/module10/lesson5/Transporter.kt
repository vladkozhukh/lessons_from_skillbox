package com.example.kitchen.module10.lesson5

abstract class Transporter (
    val maxWeight: Int
        ) {
    abstract val capacity: Int
    abstract fun move()
}