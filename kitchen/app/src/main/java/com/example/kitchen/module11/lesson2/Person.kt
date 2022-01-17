package com.example.kitchen.module11.lesson2

// правой кнопкой на Person -> "Generate" -> "equals() and hashCode()"
class Person(
    val name: String,
    val lastName: String,
    val passportSeries: Int,
    val passportNumber: Int
) {
    // equals и hashCode применятся чаще всего для работы с коллектицией

    override fun equals(other: Any?): Boolean {
        if (this === other) return true // сравниваем два разных объекта

//        if (javaClass != other?.javaClass) return false
//        other as Person
        if (other !is Person) return false // проверка на пренадлежность одному и тому же типу

        if (passportSeries != other.passportSeries) return false
        if (passportNumber != other.passportNumber) return false

        return true
    }

    // для минимального количества колизий и быстрой работы
    override fun hashCode(): Int {
        var result = passportSeries
        result = 31 * result + passportNumber
        return result
    }

    // для ввывода в консоль либо логирования
    override fun toString(): String {
        return "Person(name='$name', lastName='$lastName', passportSeries=$passportSeries, passportNumber=$passportNumber)"
    }
}