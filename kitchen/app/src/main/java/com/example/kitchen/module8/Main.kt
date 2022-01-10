package com.example.kitchen.module8

fun main() {
    val person = Person("Ivan", 32)
    val driver = Driver("Peter", 33, 3)
    person.age
    person.name
    person.walk()
    driver.age
    driver.name
    driver.walk()
    driver.experience
    driver.drive()

    //  Developers
    val ktDev = KotlinDeveloper("Roman", 23,4)
    val javDev = JavaDeveloper("Peter", 30, 4)
    val cpDev = CppDeveloper("Lesya", 28,6)
    val scalaDev = ScalaDeveloper("ScalaDev", 35,4)

    ktDev.writeCode()
    println("стаж - ${ktDev.getLevel()}")
    javDev.writeCode()
    println("стаж - ${javDev.getLevel()}")
    cpDev.writeCode()
    println("стаж - ${cpDev.getLevel()}")

    println("javaDev - ${javDev.paradigm}")
    println("scalaDev - ${scalaDev.paradigm}")

}