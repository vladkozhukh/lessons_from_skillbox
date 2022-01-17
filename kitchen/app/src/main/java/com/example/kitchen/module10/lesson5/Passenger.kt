package com.example.kitchen.module10.lesson5

class Passenger(
    val name: String,
    val lastName: String,
    val document: Document,
    val seat: Seat
) {
    fun getInfo() =
        "$name $lastName with: \n" +
                "${document.getType()} - ${document.getStringId()}"
}