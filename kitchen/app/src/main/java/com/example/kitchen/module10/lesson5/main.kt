package com.example.kitchen.module10.lesson5

import kotlin.random.Random

fun main() {

    val boeing = Boeing737()

    fillAircraft(boeing) /* для класса Boeing737() */

    println(boeing.getInfo())
    boeing.getSeatScheme()

    // расписан индивидуально НЕ полиморфизм.
    boeing.getPassenger(Seat(0, 'c'))
        ?.getInfo()
        ?.let { println(it) }
        ?: println("not this passenger")

    println("=========================")

    val zeppelin = Zeppelin()

    fillAircraft(zeppelin)  /* для класса Zeppelin() */

    println(zeppelin.getInfo())

    zeppelin.getSeatScheme()


    /* Параметрический полиморфизм */ // применив функцию getPassengerInfo(..)
    getPassengerInfo(zeppelin, Seat(0, 'b'))
    getPassengerInfo(zeppelin, Seat(0, 'c'))
}

// Полиморфизм в виде функции
fun getPassengerInfo(aircraft: Aircraft, seat: Seat) {
    aircraft.getPassenger(seat)
        ?.getInfo()
        ?.let { println(it) }
        ?: println("seat is empty")
}

// упрощение, чтобы не повторять код для классов Aircraft (Boeing737, Zeppelin)
fun fillAircraft(aircraft: Aircraft){
    val passengerCountInAirCraft = Random.nextInt(1, aircraft.capacity)
    for (i in 0 until passengerCountInAirCraft) {
        val seat = aircraft.getAvailableSeat() ?: return
        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",

            document = getDocumentPrint(),
            seat = seat
        )
        aircraft.addPassenger(passenger)
    }
}
// функция условия через интерфейс
fun getDocumentPrint(): Document =
    when (Random.nextInt(0, 2)) {
        0 -> ForeignPassport(
            serial = Random.nextInt(1000, 9999).toString(),
            number = Random.nextInt(1000000, 9999999).toString()
        )
        else -> MultiPassport(
            number = Random.nextInt(1000, 9999).toString(),
            date = "01.01.1999"
        )
    }