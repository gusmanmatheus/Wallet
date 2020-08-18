package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.UserRepository
import com.mathe.domain.User

class RegisterUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User):Long {
       return userRepository.registerUser(user)
    }
}