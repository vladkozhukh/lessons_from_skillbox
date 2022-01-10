package com.example.kitchen.module7

import kotlin.random.Random

class Car(
    val brand: String,
    val model: String,
    val color: String = "Black"
) {
    constructor(descriptor: Pair<String, String>, color: String = "Black") : this(
        brand = descriptor.first,
        model = descriptor.second,
        color = color
    ) {
        println("constructor init")
    }

    init {
        println("Car init")
    }

    var currentSpeed = 0.0
        private set


    private var fuelCount = 0.0


    init {
        println("Car second init")
    }

    fun accelerate(speed: Double) {
        val needFuel = speed * 0.1
        if (fuelCount > needFuel) {
            currentSpeed += speed
            useFuel(needFuel)
        } else
            println("Need fuel!")
    }

    fun decelerate(speed: Double) {
        currentSpeed = maxOf(0.0, currentSpeed - speed)
    }

    private fun useFuel(fuelCount: Double) {
        this.fuelCount -= fuelCount
    }


    fun start() {
        println("Car start")
    }

    fun move() {
        val distance = Random.nextInt(1, 100)
        val speed = Random.nextInt(10, 100)
        println("Car passed $distance km with speed = $speed km/h")
    }

    fun stop() {
        println("Car stopped")
    }
}