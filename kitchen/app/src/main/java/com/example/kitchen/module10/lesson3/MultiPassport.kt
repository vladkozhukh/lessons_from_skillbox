package com.example.kitchen.module10.lesson3

class MultiPassport(
    private val number: String,
    private val date: String /* добавление доп. поля */
): Document {
    override fun getStringId(): String = "$number $date" /*корректировка ввывода строки*/
    override fun getType(): String = "Multi passport"
}