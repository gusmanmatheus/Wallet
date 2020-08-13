package com.example.data

import com.example.data.repository.UserRepository
import com.example.domain.User

class RegisterUser(private val userRepository: UserRepository) {
    suspend fun invoke(user: User):Boolean {
       return userRepository.register(user)
    }
}