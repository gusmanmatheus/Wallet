package com.example.home

import com.mathe.data.usercasehome.*
import com.mathe.data.usercaselogin.GetActiveUser
import com.mathe.data.usercaselogin.Logout

data class HomeInteractor(
    val getWallet: GetWallet,
    val updateWallet: UpdateWallet,
    val getQuotationDollar: GetQuotationDollar,
    val getQuotationBitcoin: GetQuotationBitcoin,
    val userActive: GetActiveUser,
    val salveTransaction: SalveTransaction,
    val logout: Logout
)