package com.example.kitchen.module11.lesson3

import kotlin.random.Random

fun main() {
    val boeing = Boeing737()
    fillAircraft(boeing)
    println(boeing.getInfo())
    boeing.getSeatScheme()
    boeing.getPassenger(Seat(0, 'c'))
        ?.getInfo()
        ?.let { println(it) }
        ?: println("not this passenger")

    println("=========================")

    val zeppelin = Zeppelin()
    fillAircraft(zeppelin)
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    getPassengerInfo(zeppelin, Seat(0, 'b'))
    getPassengerInfo(zeppelin, Seat(0, 'c'))
}

fun getPassengerInfo(aircraft: Aircraft, seat: Seat) {
    aircraft.getPassenger(seat)
        ?.getInfo()
        ?.let { println(it) }
        ?: println("seat is empty")
}

fun fillAircraft(aircraft: Aircraft) {
    val passengerCountInAirCraft = Random.nextInt(1, aircraft.capacity)
    for (i in 0 until passengerCountInAirCraft) {
        val seat = aircraft.getAvailableSeat() ?: return
        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = getDocument(aircraft), /* прописываем тут функцию */
            seat = seat
        )
        aircraft.addPassenger(passenger)
    }
}
// сравнение типов через интерфейс
fun getDocument(aircraft: Aircraft): Document =
    if (aircraft is Zeppelin) {
        MultiPassport(
            number = Random.nextInt(1000, 9999).toString(),
            date = "01.01.1999"
        )
    } else
        ForeignPassport(
            serial = Random.nextInt(1000, 9999).toString(),
            number = Random.nextInt(1000000, 9999999).toString()
        )