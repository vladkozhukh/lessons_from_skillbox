package com.example.kitchen.module11.lesson5

import java.util.*

//Инвариантность Generic<T> -> отсутствие наследования между производными типами
class Generic<T> (value: T) {
    var item: T? = value
    private set
    var initializedDate = Date()

    fun setItem(newItem: T?){ // фунция замены значения элемента
        item = newItem
    }
}