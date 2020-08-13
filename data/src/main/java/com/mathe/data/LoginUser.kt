package com.mathe.data

import com.mathe.data.repository.UserRepository
import com.mathe.domain.User

class LoginUser(private val userRepository: UserRepository) {
    suspend fun invoke(username: String, password: String): User? {
        return userRepository.login(username, password)
    }
}