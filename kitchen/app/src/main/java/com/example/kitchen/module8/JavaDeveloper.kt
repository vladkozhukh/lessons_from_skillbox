package com.example.kitchen.module8

class JavaDeveloper  : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode() {
        println("java разработчик пишет код")
    }

    override fun getLevel(): String = when(experience){
        0 -> "Intern"
        in 1..4 -> "Junior"
        in 5..6 -> "Middle"
        in 7..8 -> "Senior"
        else -> "leading"
    }


}