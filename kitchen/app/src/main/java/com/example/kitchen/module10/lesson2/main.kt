package com.example.kitchen.module10.lesson2

fun main() {
    val devices = listOf(
        MobilePhone(),
        RadioPhone(),
        SmartFridge(),
        AppleWatch(),
        DiskPhone())

    devices.forEach{it.call("+375291504185") }

    /* 1 */
    val mobilePhone = MobilePhone()
    mobilePhone.call("+375291504185")
    mobilePhone.getUrl("www.site.com")

    /* 2 */
    val webDevices = listOf<WebBrowser>(MobilePhone(), SmartTV())
    webDevices.forEach {
        it.getUrl("www.website.com")
        // it.call("tel.") - не работает в из-за <WebBrowser>
    }
}