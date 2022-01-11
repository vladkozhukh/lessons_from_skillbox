package com.example.kitchen.module9

abstract class Transporter (
    val maxWeight: Int
        ) {
    abstract val capacity: Int
    abstract fun move()
}