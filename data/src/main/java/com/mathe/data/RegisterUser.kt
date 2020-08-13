package com.mathe.data

import com.mathe.data.repository.UserRepository
import com.mathe.domain.User

class RegisterUser(private val userRepository: UserRepository) {
    suspend fun invoke(user: User):Boolean {
       return userRepository.register(user)
    }
}