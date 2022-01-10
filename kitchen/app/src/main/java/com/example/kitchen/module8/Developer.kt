package com.example.kitchen.module8

import kotlin.random.Random

open class Developer(
    name: String,
    age: Int,
    protected val experience: Int = 2
) : Person(name, age) {
    open val paradigm = "OOP"
    open fun writeCode() = println("Писать код")
    open fun getLevel() = when (experience) {
        0 -> "Intern"
        in 1..2 -> "Junior"
        in 3..4 -> "Middle"
        in 5..6 -> "Senior"
        else -> "leading"
    }

    protected open fun getCoffeeBreak() = Random.nextBoolean()
}