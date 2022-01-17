package com.example.kitchen.module11.lesson3

import com.example.kitchen.module8.Developer
import com.example.kitchen.module8.Person

fun main() {
//    val developer = Developer("Peter", 40)
//    developer.writeCode()
//    developer.getLevel()
//
//    // иерархия Developer наследуется от Person -> приведение типов допустимо
//    val person: Person = developer
//    person.writeCode() /* нельзя */

    val person: Person = Person("Peter2", 41)

    /* приведение типов удалось так как стр. 15 "Person = Developer" */
    val developer: Developer? = person as? Developer

    /* если -> val person: Person = Person("Peter2", 41) -> null */

    developer?.writeCode()
    println(developer?.getLevel())

}