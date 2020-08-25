package com.example.home

import com.mathe.data.usercasehome.GetAllTransactions
import com.mathe.data.usercaselogin.GetActiveUser

data class ReceiptInteractor(val getAllTransactions: GetAllTransactions, val getActiveUser: GetActiveUser)