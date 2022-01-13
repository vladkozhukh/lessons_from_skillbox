package com.example.kitchen.module9

class MultiPassport(
    private val number: String
): Document {
    override fun getStringId(): String = number
    override fun getType(): String = "Multi passport"
}