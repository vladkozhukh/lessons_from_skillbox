package com.example.kitchen.module9.lesson3

fun main() {
    val train = Train(10000)
    println("capacity - ${train.capacity} and max weight - ${train.maxWeight}")
    train.move()
}