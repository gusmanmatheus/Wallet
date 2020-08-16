package com.mathe.data.usercaselogin

import com.mathe.data.repository.UserRepository
import com.mathe.domain.User

class AuthenticateUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String, password: String): User? {
        return userRepository.authenticateUser(username, password)
    }
}