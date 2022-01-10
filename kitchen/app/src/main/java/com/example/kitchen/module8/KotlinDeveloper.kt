package com.example.kitchen.module8

class KotlinDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode() {
        println("kotlin разработчик пишет код")
        super.getCoffeeBreak()
    }

    override fun getCoffeeBreak() = true
}
