package com.mathe.login

import com.mathe.data.usercaselogin.*

data class LoginInteractor(
    val authenticate: AuthenticateUser,
    val findUserId: FindUserId,
    val getActiveUser: GetActiveUser,
    val login: Login

)
