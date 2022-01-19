package com.example.kitchen.module11.lesson5

import com.example.kitchen.module7.Car
import com.example.kitchen.module8.Developer
import com.example.kitchen.module8.Person

fun main() {
    val object1 = Generic(5)
    val object2 = Generic("string")
    val object3 = Generic(Car("Nissan", "Q3", "Black"))

    val person = Generic(Person("Peter", 20))
    person.setItem(Developer("Ann", 25)) // Developer наследуется от Person

    // GenericOut
    val first = GenericOut(5.0)
    val second = GenericOut(10)
    sum(first, second)

    // Person <in T:..>
    val developer = Developer("Peter", 32)
    printerInPerson(Printer<Person>(), developer) // не подчеркивает Printer<Person>() потому что <in T:..>

}

fun sum(a: GenericOut<Number>, b: GenericOut<Number>): Int? {
    val first = a.getItem()?.toInt() ?: return null
    val second = a.getItem()?.toInt() ?: return null
    return first + second
}

// Контравариантность Person <in T: ..>
fun printerInPerson(printer: Printer<Developer>, developer: Developer){
    // some logic
    printer.print(developer)
}