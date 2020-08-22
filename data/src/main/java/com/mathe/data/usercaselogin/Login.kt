package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.UserRepository

class Login(private val userRepository: UserRepository) {
    suspend operator fun invoke(id:Long):Int {
        return userRepository.login(id)
    }
}