package com.example.home

import com.mathe.data.usercasehome.GetQuotationBitcoin
import com.mathe.data.usercasehome.GetQuotationDollar
import com.mathe.data.usercasehome.GetWallet
import com.mathe.data.usercasehome.UpdateWallet
import com.mathe.data.usercaselogin.GetActiveUser

data class HomeInteractor(
    val getWallet: GetWallet,
    val updateWallet: UpdateWallet,
    val getQuotationDollar: GetQuotationDollar,
    val getQuotationBitcoin: GetQuotationBitcoin,
    val userActive: GetActiveUser
)