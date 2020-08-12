package com.example.data

import com.example.data.repository.UserRepository

class RegisterUser(private val userRepository: UserRepository) {
    suspend fun invoke(){
        userRepository.register()
    }
}