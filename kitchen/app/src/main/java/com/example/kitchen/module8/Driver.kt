package com.example.kitchen.module8

class Driver(
    nameArgs: String,
    ageArgs: Int,
    val experience: Int
) : Person(
    nameArgs,
    ageArgs
) {
    fun drive() = println("Водить")
}