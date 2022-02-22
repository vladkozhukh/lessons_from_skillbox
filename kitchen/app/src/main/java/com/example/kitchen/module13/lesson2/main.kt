package com.example.kitchen.module13.lesson2

import kotlin.concurrent.thread

fun main() {
LoadHelper.load()
}

object LoadHelper {
    private var progress: Int = 0
    private fun startLoading() {
        thread {
            while (progress < 100) {
                progress++
                Thread.sleep(500)
            }
        }
    }

    private fun updateProgressBar() {
        thread {
            while (progress < 100) {
                println(getProgressString())
                Thread.sleep(100)
            }
        }
    }

    private fun getProgressString(): String {
        val str = StringBuilder()
        for (i in 1..100) {
            if (i < progress)
                str.append("#") else str.append(".")
        }
        str.append(" $progress %")
        return str.toString()
    }

    fun load() {
        startLoading()
        updateProgressBar()
    }
}

