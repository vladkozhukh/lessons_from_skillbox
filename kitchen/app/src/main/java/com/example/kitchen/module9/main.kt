package com.example.kitchen.module9

import kotlin.random.Random

fun main() {
//    val train = Train(10000)
//    println("capacity - ${train.capacity} and max weight - ${train.maxWeight}")
//    train.move()


    val boeing = boeingType()
    println(boeing.getInfo())
    boeing.getSeatScheme()
    boeing.getPassenger(Seat(0, 'c'))
        ?.getInfo()
        ?.let { println(it) }
        ?: println("not this passenger")

    println("=========================")

    val zeppelin = Zeppelin()
    val passengerCountZep = Random.nextInt(1, zeppelin.capacity)

    for (i in 0 until passengerCountZep) {
        val seat = zeppelin.getAvailableSeat() ?: return

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = MultiPassport(
                Random.nextInt(1000,9999).toString()
            ),
            seat = seat
        )
        zeppelin.addPassenger(passenger)
    }

    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    zeppelin.getPassenger(Seat(0, 'c'))
        ?.getInfo()
        ?.let { println(it) }
        ?: println("not this passenger")
}

fun boeingType(): Boeing737 {
    val boeing = Boeing737()
    val passengerCount = Random.nextInt(1, boeing.capacity)

    for (i in 0 until passengerCount) {
        val seat = boeing.getAvailableSeat() ?: return boeing

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = ForeignPassport(
                serial = Random.nextInt(1000,9999).toString(),
                number = Random.nextInt(1000000,9999999).toString()
            ),
            seat = seat
        )
        boeing.addPassenger(passenger)
    }
    return boeing
}