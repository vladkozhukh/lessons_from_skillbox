package com.example.kitchen.module11.lesson4

sealed class SealedColor(val hex: String){
    object White : SealedColor("#FFF")
    object Black : SealedColor("#888")
    object Red : SealedColor("#AAA")
    class Blue : SealedColor("#AFA")

    class CustomColor(hex:String): SealedColor(hex)
}
