package com.example.kitchen.module10.lesson5

class MultiPassport(
    private val number: String,
    private val date: String
): Document {
    override fun getStringId(): String = "$number $date"
    override fun getType(): String = "Multi passport"
}