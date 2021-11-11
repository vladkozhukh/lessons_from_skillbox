package com.example.lists

import org.threeten.bp.Instant

data class Dataset(
    val id: Long,
    val text: String,
    val createdAt: Instant
    )