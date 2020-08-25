package com.mathe.login

import com.mathe.data.usercaselogin.CreateNewWallet
import com.mathe.data.usercaselogin.GetActiveUser

data class CongratulationsInteractor(
    val getActiveUser: GetActiveUser,
    val createNewWallet: CreateNewWallet
)