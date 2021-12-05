package com.example.kitchen.oop

class Car constructor(
    val doorCount: Int,
    val wheelCount: Int,
    val bodyLength: Int,
    val bodyWidth: Int,
    val bodyHeight: Int
) {

    init {
        println("Car init")
    }

    var currentSpeed: Int = 0
    get() {
        println("currentSpeed get")
        return field /* возвращяется к значению, но не повторяется get блок-боди */
    }
    private set(value) { /* принимает новое значение */
        println("currentSpeed set $value")
        field = value
    }
    var fuelCount: Int = 0
    private set

    constructor(doorCount: Int, wheelCount: Int, bodySize: Triple<Int, Int, Int>) : this(
        doorCount,
        wheelCount,
        bodySize.first,
        bodySize.second,
        bodySize.third
    ) {
        println("Car.constructor init")
    }

    // Определение метода:
    fun accelerate(speed: Int) {
        val needFuel = speed / 2
        if (fuelCount >= needFuel) {
            currentSpeed += speed
            useFuel(needFuel)
        } else {
            println("You need fuel")
        }
    }

    fun deaccelerate(speed: Int) {
        // maxOf болшее из двух значений a = 0 или b = -100 -> 0
        currentSpeed = maxOf(0, currentSpeed - speed)
    }

    fun useFuel(fuelCount: Int) {
        this.fuelCount -= fuelCount

    }

    fun reFuel(fuelCount: Int) {
        if (currentSpeed == 0) {
            this.fuelCount += fuelCount
        } else {
            println("you can't refuel with current speed != 0")}
    }
}