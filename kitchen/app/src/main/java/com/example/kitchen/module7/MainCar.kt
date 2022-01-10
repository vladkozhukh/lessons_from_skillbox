package com.example.kitchen.module7

fun main() {
    val audi = Car("Audi", "A3", "blue")
    val toyota = Car("Toyota", "B8")

    val nissan = Car("Nissan" to "Almera", "white")
//    println("${nissan.currentSpeed} -> ${nissan.fuelCount}")

    nissan.accelerate(100.0)
//    println("${nissan.currentSpeed} -> ${nissan.fuelCount}")
    nissan.decelerate(50.0)
//    println("${nissan.currentSpeed} -> ${nissan.fuelCount}")

//    audi.currentSpeed = 100.0 /* private set изменять значение нельзя */
//    audi.currentSpeed /* считать значение можно */

}

fun printInfo(car: Car) {
    println("${car.brand}, ${car.model}, ${car.color}")
    car.move()
}