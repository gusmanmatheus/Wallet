package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.UserRepository
import com.mathe.domain.User

class GetActiveUser (private val userRepository: UserRepository) {
    suspend operator fun invoke(): User? {
        return userRepository.getActiveUser()
    }
}