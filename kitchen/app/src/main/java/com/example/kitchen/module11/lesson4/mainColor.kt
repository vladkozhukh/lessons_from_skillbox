package com.example.kitchen.module11.lesson4

fun main() {
    Color.BLACK
    Color.GREEN

    Color.BLACK.draw()
    Color.GREEN.draw() /* тут переопределение было */

    println(Color.RED.hex) /* вывод значения в консоль */

    println(Color.values().joinToString(" , ")) /* вывод всех значений */
    println(Color.valueOf("RED").hex) /* поиск по строке valueOf , но считается не безопасный*/

    Color.values().forEach {
        println("${it.name} - ${it.ordinal}") /* it.name - имя it.ordinal - порядковый номер */
    }
}
 // при работе с перечислениями enum class перечислить все параметры тела
fun switchColor(color: Color): Color =
    when (color) {
        Color.RED -> Color.GREEN
        Color.GREEN -> Color.RED
        Color.BLACK -> Color.WHITE
        Color.BLUE -> Color.BLACK
        Color.WHITE -> Color.BLUE
    }

fun sealedColor(color: SealedColor): SealedColor =
    when(color){
        SealedColor.Black -> SealedColor.White
        SealedColor.White -> SealedColor.Blue()
        is SealedColor.Blue -> SealedColor.Red
        SealedColor.Red -> SealedColor.Black

        // используем оператор is для class
        is SealedColor.CustomColor -> SealedColor.CustomColor("#FF0")
    }