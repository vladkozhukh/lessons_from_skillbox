package com.example.kitchen
/* Условные выражения */

fun main() {
    println(getTypeCarWhenReturn(1, false))

    println(getDeveloperPosition(-1))
    println(getDeveloperPosition(2))
    println(getDeveloperPosition(3))
    println(getDeveloperPosition(6))
}

/* Пример: Оператор when (аналог switch в Java, заменяет множественный if-else-if) */

fun getTypeCarReturnWhen(
    maxSpeed: Int,
    sportMode: Boolean
): String {
    return when {
        maxSpeed < 10 -> "Пешеход"
        maxSpeed < 20 -> "Самокат"
        sportMode && maxSpeed <= 75 -> "Скутер"
        maxSpeed >= 76 -> "Машина"
        else -> {
            "Пешеход"
        }
    }
}

fun getTypeCarWhenReturn(
    maxSpeed: Int,
    sportMode: Boolean
): String {
    var a = "Пешеход" /* стандартное имя переменной */
    when {
        maxSpeed < 10 -> a /* без замены стандартной пременной */
        maxSpeed < 20 -> {
            "Уже это..."
            a = "Электросамокат" /* замена стандартной переменной */
        }
        sportMode && maxSpeed <= 75 -> "Скутер" /* хардкорд с применением логического выражения */
        maxSpeed >= 76 -> "Машина" /* хардкорд без логического выражения */
    }
    return a        /* условия не соблюдаются - возврат стандартной переменной */
    // return "Пешеход" /* условия не соблюдаются - хардкорд */
}

/* Оператор in и .. (двоеточие/диапазон).
Двоеточие в Kotlin обозначает диапазон значений от ... по ... (включая).
In проверяет вхождение в данный диапазон*/

fun getDeveloperPosition(experience: Int): String {
    return if (experience < 0) {
        "No experience"
    } else {
        when (experience) {
            0 -> "Intern"
            in 1..2 -> "Junior"
            in 3..4 -> "Middle"
            else -> "Senior"
        }
    }
}