package com.mathe.domain

data class User(
    val id: Long = 0,
    val username: String,
    val name: String,
    val password: String,
    var active: Int = 0
) {
}