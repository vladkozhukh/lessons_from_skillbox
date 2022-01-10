package com.example.kitchen.module8

class CppDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode() {
        super.writeCode()
        println("c++ разработчик пишет код")
    }
}