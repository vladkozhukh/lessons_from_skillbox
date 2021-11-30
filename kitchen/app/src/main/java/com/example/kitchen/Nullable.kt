package com.example.kitchen


fun main() {

    val string: String = "string"
    val nullableString: String? = "string" /* null */

    val nullableLength = nullableString?.length
    nullableString?.reversed()
        ?.find { it == '4' }
        ?.isDigit()

    // Проверка на null
    if (nullableString != null){
        println("String length is ${nullableString.length}")
    } else{
        println("String is null")
    }

    // Упрощенный вариант проверки
    // Оператор ?: (Элвис-оператор). Выполняет код после двоеточия, если значение перед вопросительным знаком равно null
    println("String length is ${nullableString?.length ?: "String is null"}")

    printLength("342434")

    printLengthAssert("1234")

    // Функция let. Лямбда-функция, у которой аргумент it является не nullable-типа
    println("Ввести число:")
    readLine()?.toIntOrNull()
        ?.let {
            println("Ввели число: $it")
        }
        ?: println("Ввели не число!")

}

    // Функция принимает nullable type
    fun printLength(string: String?){
    string ?: return
    print("Length string ${string.length}")
}

    // Оператор !! (not null assert). Указывает, что в переменной в данном коде точно не null-значение
    fun printLengthAssert(string: String?){
    print("Length string ${string!!.length}")
    }

