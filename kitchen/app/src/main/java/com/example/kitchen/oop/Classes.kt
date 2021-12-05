package com.example.kitchen.oop

fun main() {
    // после ввода аргументов идет init{println("Car init")}
    val nissan = Car(5,4,100,200,150)

    // после ввода аргументов идет снова init{println("Car init")} потом снова ввод аргумнетов с constructor
    val audi = Car(5,4, Triple(100,200,150))

    nissan.accelerate(100)
    println("${nissan.currentSpeed}")

    nissan.deaccelerate(50)
    println("speed = ${nissan.currentSpeed}, fuel = ${nissan.fuelCount}")
}