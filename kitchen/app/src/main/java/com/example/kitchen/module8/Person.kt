package com.example.kitchen.module8

open class Person(
    val name: String,
    val age: Int
) {
    fun walk() = println("ходить")
    fun sleep() = println("спать")
    fun eat() = println("кушать")
}