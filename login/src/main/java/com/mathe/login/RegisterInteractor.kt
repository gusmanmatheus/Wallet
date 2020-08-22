package com.mathe.login

import com.mathe.data.usercaselogin.FindUserId
import com.mathe.data.usercaselogin.Login
import com.mathe.data.usercaselogin.RegisterUser
import com.mathe.data.usercaselogin.CreateNewWallet

class RegisterInteractor(
    val register: RegisterUser,
    val findUserId: FindUserId,
    val login: Login
)
