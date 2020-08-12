package com.example.data.datasource

interface UserDataSource {
    suspend fun registerUser()
    suspend fun login()
}