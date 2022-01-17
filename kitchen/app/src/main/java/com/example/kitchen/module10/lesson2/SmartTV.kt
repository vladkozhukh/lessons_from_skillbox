package com.example.kitchen.module10.lesson2

class SmartTV: WebBrowser, Callable {
    override val vendor = "Xiaomi"

    override fun call(number: String) {
        println("smart tv calling $number")
    }

    override fun getUrl(url: String) {
        println("smart tv get url $url")
    }
}