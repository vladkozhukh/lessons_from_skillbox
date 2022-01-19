package com.example.kitchen.module11.lesson5

import java.util.*

// Ковариантность Generic<out T> класс отдает значение типа <T>

class GenericOut<out T: Number>(value: T) {
    private var item: T? = value
    var initializedDate = Date()


// фунция замены значения элемента из-за Ковариантности не будет работать, потому что отдаем а не заменяеми
//    fun setItem(newItem: T?){
//        item = newItem
//    }

    fun getItem() = item

}