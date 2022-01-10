package com.example.kitchen.kotlin

fun main() {
    // Set-множества. Множество уникальных значений
    val immutableSet = setOf(1, 2, 3, 3, 4, 5, 6, 7, 7, 8)
    println(immutableSet)

    // union (объединение уникальных значений двух списков)
    val unionSet = setOf(1, 2, 3).union(setOf(1, 4, 5))
    println(unionSet + "union")

    // subtract (возвращает элементы, которые есть в одном списке, но нет в другом)
    val subtractSet = setOf(1, 2, 3).subtract(setOf(1, 4, 5))
    println(subtractSet + "subtract")

    // intersect (объединение двух списков)
    val intersect = setOf(1, 2, 3).intersect(setOf(1, 4, 5))
    println(intersect + "intersect")

    val naturalOrderSet = sortedSetOf(1, 3, 0, -1, 10)
    println(naturalOrderSet + "sortedSetOf 1..10")
    // Метод descendingSet (расположит значения в обратном порядке)
    println(naturalOrderSet.descendingSet() + "descendingSet 10..1")

    // делаем его изменяемым .toMutableSet чтобы добавить в него индексы и элементы
    val naturalMutableSet = sortedSetOf(1, 3, 0, -1, 10).toMutableSet()
    naturalMutableSet.add(5)
    /* или */
    mutableListOf(1, 2, 3).add(4)

    // Метод hashSetOf изначално mutable

    val hashSet = hashSetOf(1,2,3)

    // Методы add, remove, contains
    hashSet.add(0)
    hashSet.remove(2)

    // содержиться ли в списке "1"
    hashSet.contains(1) /* 1ой  вариант данной записи */
    println(hashSet.contains(1)) /* true */
    // содержиться ли в списке "2"
    2 in hashSet /* 2ой  вариант данной записи */
    println(2 in hashSet) /* false */

}