package com.example.kitchen

fun main() {
    val immutableList = listOf("zero", "one", "two", "three")
    // immutableList[0] = "1.2" - нельзя см.стр. 15-16

    println(immutableList)

    immutableList[0]

    immutableList.forEach{ println(it)}

    val emptyList = emptyList<String>()

    val mutableList = mutableListOf("zero", "one", "two", "three")
    mutableList[0] = "1.2"

    mutableList.removeAt(0) /* удаление "zero" */
    mutableList.add(1,"new one") /* добавление по индексу */
    mutableList.add("four") /* добавление в конец списка */
    mutableList.addAll(listOf("5", "6"))

    println(mutableList)
}