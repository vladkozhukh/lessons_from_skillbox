package com.example.kitchen.module9

class ForeignPassport(
    private val serial: String,
    private val number: String
): Document {
    override fun getStringId(): String = "$serial $number"

    override fun getType(): String = "Foreign passport"
}