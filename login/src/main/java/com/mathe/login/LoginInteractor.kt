package com.mathe.login

import com.mathe.data.usercaselogin.AuthenticateUser
import com.mathe.data.usercaselogin.FindUserId
import com.mathe.data.usercaselogin.RegisterUser

data class LoginInteractor(
    val authenticate: AuthenticateUser,
    val register: RegisterUser,
    val findUserId: FindUserId
)
