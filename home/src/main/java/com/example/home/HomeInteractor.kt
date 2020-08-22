package com.example.home

import com.mathe.data.usercasehome.GetQuotationBitcoin
import com.mathe.data.usercasehome.GetQuotationDollar
import com.mathe.data.usercasehome.GetWallet
import com.mathe.data.usercasehome.UpdateWallet

class HomeInteractor(
    getWallet: GetWallet,
    updateWallet: UpdateWallet,
    getQuotationDollar: GetQuotationDollar,
    getQuotationBitcoin: GetQuotationBitcoin
)