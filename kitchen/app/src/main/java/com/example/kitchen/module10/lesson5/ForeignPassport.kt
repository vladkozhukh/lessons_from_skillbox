package com.example.kitchen.module10.lesson5

class ForeignPassport(
    private val serial: String,
    private val number: String
): Document {
    override fun getStringId(): String = "$serial $number"

    override fun getType(): String = "Foreign passport"
}