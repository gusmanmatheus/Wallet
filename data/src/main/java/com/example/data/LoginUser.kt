package com.example.data

import com.example.data.repository.UserRepository
import com.example.domain.User

class LoginUser(private val userRepository: UserRepository) {
    suspend fun invoke(username: String, password: String): User? {
        return userRepository.login(username, password)
    }
}