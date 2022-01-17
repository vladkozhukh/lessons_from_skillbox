package com.example.kitchen.module10.lesson2


class MobilePhone: CallReceiver, WebBrowser { /* удалаяем "Callable" так как он есть уже в "CallReceiver" */
    override val vendor = "HTC"

    override fun call(number: String) {
        println("mobile phone calling $number")
    }

    override fun receiver(number: String) {
        super.receiver(number)
        println("LED ON")
    }

    override fun getUrl(url: String) {
        println("mobile phone open url $url")
    }
}