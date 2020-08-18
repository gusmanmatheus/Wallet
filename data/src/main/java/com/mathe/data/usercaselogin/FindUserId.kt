package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.UserRepository

class FindUserId(private val userRepository: UserRepository) {
    suspend operator fun invoke(username:String): Long? {
        return userRepository.findUserByUsername(username)
    }
}