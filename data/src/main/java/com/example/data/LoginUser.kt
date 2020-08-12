package com.example.data

import com.example.data.repository.UserRepository

class LoginUser(private val userRepository: UserRepository) {
    suspend fun invoke(){
        userRepository.login()
    }
}