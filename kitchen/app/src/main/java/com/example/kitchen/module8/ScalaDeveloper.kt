package com.example.kitchen.module8

class ScalaDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override val paradigm = "Functional"
}