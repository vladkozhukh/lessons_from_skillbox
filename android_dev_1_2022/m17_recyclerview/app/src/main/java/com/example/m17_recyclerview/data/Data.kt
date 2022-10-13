package com.example.m17_recyclerview.data

data class Data(
    val photos: ArrayList<Photo>
)

data class Photo(
    val img_src: String,
    val earth_date: String,
    val rover: Rover,
    val camera: Camera,
    val sol: Int
)

data class Rover(
    val name: String
)

data class Camera(
    val name: String
)