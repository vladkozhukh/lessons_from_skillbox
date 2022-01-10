package com.example.kitchen.kotlin

fun main() {
    val pair1 = Pair("key", "value")
    val pair2 = 1 to 2

    println("${pair1.first}, ${pair1.second}")
    println(pair2)

    val map = mapOf(
        "1" to "+375-111-11-11",
        "1" to "+375-NEW-11-11", /*перезапись ключа "1" */
        "2" to "+375-222-22-22",
        "3" to "+375-333-33-33",
    )

    println(map["1"])
    println(map["3"])

    // изначально map immutable, длеаем mutable:
    val mutableMap = map.toMutableMap()

    mutableMap["1"] = "111" /* замена 1го ключа */
    mutableMap["11"] = "111-11-11" /* добавление ключа */
    mutableMap.put("new key", "new value") /* добавление ключа */
    mutableMap.put("new key2", "new value2") /* добавление ключа */

    mutableMap.remove("new key2") /* удаление по ключу */

    println("$mutableMap")

    // создание сразу mutable map:
    val mutableMap2 = mutableMapOf("one" to "new one")

    // перевод обратно в immutable map (list, set):
    mutableMap2.toMap()

    // Функции sortedMapOf и hashMapOf
    val sortedMap = sortedMapOf(
        "1" to "11",
        "3" to "33",
        "4" to "44",
        "2" to "22")
    println(sortedMap)

    val hashMap = hashMapOf(
        "1" to "one",
        "3" to "three",
        "4" to "four",
        "2" to "two")
    println(hashMap)

    println(hashMap.keys) /* только ключи */
    println(hashMap.values) /* только значения по ключу */

    // вывод ключа в списке ключей:
    for (key in hashMap.keys){
        println("$key, value = ${hashMap.keys} ")
    }

    hashMap.forEach{ entry-> entry.key
    entry.value
    }
}