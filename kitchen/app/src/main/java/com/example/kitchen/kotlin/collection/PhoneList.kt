package com.example.kitchen.kotlin.collection

fun main() {
    // 1.Введите число N с клавиатуры.
    print("Введите число N с клавиатуры: ")
    val number: Int = inputNum()
    val listNumber = phoneList(number)
    val filterWithPrefix = listNumber.filter { it.startsWith("+7")}
    // 5. Выведите в консоль только номера телефонов, начинающиеся с приставки +7.
    println("Номера с приставкой +7: $filterWithPrefix")
    // 6. Выведите в консоль количество уникальных введённых номеров.
    println("Уникальные номера: " + listNumber.toSet().size)
    // 7. Вычислите и распечатайте сумму длин всех номеров телефонов
    println("Сумма длин всех номеров: " + listNumber.sumOf { it.length })
    // 8. Создайте изменяемое отображение — MutableMap.
    val map = mutableMapOf<String, String>()
    for (numberInList in listNumber){
        print("Введите имя человека с номером телефона ${numberInList}: ")
        val nameOfNumber = readLine() ?: continue
        map[numberInList] = nameOfNumber
    }
    // 9. Выведите в консоль всё содержание Map в следующем виде:
    for (entry in map){
        println("Человек: ${entry.value}. Номер телефона: ${entry.key}")
    }
}

fun inputNum(): Int {
    return readLine()?.toIntOrNull() ?: inputNum()
}

// 4.1 Вынесите шаги 2-3 в функцию, которая принимает число N...
fun phoneList(n:Int): List<String> {
    // 3.2 Для этого создайте MutableList и добавляйте в него элементы в цикле.
    val list = mutableListOf<String>()
    // 2. Введите следующие N номеров телефонов пользователей.
    repeat(n) {
        print("Введите следующий номер телефона пользователя: ")
        val phoneNumber = readLine().toString() // 2.1 Каждый номер должен представлять из себя строку.
        // 3.1 Сохраните номера в список.
        list.add(phoneNumber)
    }
    return list // 4.2 ...возвращает список из N номеров телефонов,введённых с клавиатуры.
}