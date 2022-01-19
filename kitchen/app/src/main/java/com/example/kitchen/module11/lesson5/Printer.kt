package com.example.kitchen.module11.lesson5

import com.example.kitchen.module8.Person

class Printer<in T:Person> {
    fun print(person: T){
        println("print ${person.name}")
    }
}