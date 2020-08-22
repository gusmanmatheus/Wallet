package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.UserRepository

class Logout(private val userRepository: UserRepository) {
    suspend operator fun invoke() {
        userRepository.logout()
    }
}