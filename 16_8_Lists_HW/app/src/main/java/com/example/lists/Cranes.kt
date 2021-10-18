package com.example.lists

sealed class Cranes {
    data class Tower(
        val avatarLink: String,
        val name: String,
        val jib: Float,
        val lifting: Int,
        val height: Float
    ): Cranes()

    data class Auto(
        val avatarLink: String,
        val name: String,
        val jib: Float,
        val lifting: Int,
        val outriggers: String
    ): Cranes()
}