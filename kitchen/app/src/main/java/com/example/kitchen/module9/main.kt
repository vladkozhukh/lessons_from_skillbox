package com.example.kitchen.module9

import kotlin.random.Random

fun main() {
//    val train = Train(10000)
//    println("capacity - ${train.capacity} and max weight - ${train.maxWeight}")
//    train.move()


    val boeing = boeingType()
    println(boeing.getInfo())
    boeing.getSeatScheme()

    println("=========================")

    val zeppelin = Zeppelin()
    val passengerCountZep = Random.nextInt(1, zeppelin.capacity)

    for (i in 0 until passengerCountZep) {
        val seat = zeppelin.getAvailableSeat() ?: return

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            passport = "${Random.nextInt(1000, 9999)} ${Random.nextInt(100000, 999999)}",
            seat = seat
        )
        zeppelin.addPassenger(passenger)
    }

    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
}

fun boeingType(): Boeing737 {
    val boeing = Boeing737()
    val passengerCount = Random.nextInt(1, boeing.capacity)

    for (i in 0 until passengerCount) {
        val seat = boeing.getAvailableSeat() ?: return boeing

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            passport = "${Random.nextInt(1000, 9999)} ${Random.nextInt(100000, 999999)}",
            seat = seat
        )
        boeing.addPassenger(passenger)
    }
    return boeing
}