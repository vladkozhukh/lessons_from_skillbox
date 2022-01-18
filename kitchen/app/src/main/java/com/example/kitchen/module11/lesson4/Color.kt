package com.example.kitchen.module11.lesson4

enum class Color(val hex: String): Drawable {
    RED("#FFF"),
    WHITE("#000"),
    BLACK("#F00"),

    // тут идет переопределение функции draw()
    GREEN("#0F0") {
        override fun draw() {
            println("draw fun override $hex")
        }
                  },

    BLUE("#00F"); /* ставим разделитель ; */

    fun someMethod(){
        println("print color")
    }

    override fun draw() {
        println("draw color $hex")
    }
}