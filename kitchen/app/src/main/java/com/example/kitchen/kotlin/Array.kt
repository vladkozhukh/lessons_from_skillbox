package com.example.kitchen.kotlin
// Array-массив и метод arrayOf. Метод arrayOf создаёт массив из переданных значений

fun main() {
    val array = arrayOf("one", "two", "three")

    for (user in array){
        println(user)
    }

    array.forEach { println(it) }

    // Метод foreach/foreachIndexed.
    // Методы foreach — это лямбда-функция, которая перебирает значение из коллекции и выполняет для них переданные действия

    array.forEachIndexed { index, user -> println("$index -> $user") }
    // Обращение по индексу
    val firstElement = array[0] /* первый элемент в списке */
    val lastElement = array[array.lastIndex] /* послдений элемент в списке */

    // замена элемента в списке
    array[0] = "New one"
    array.forEach { println(it) }

    // Метод emptyArray и класс Array
    // пустой список нужно обязательно указывать тип, класс и т.д. в <...>
    val emptyArray = emptyArray<String>()

    val largeArray = Array(100){size -> "Index $size"}
    largeArray.forEach { println(it)}

}