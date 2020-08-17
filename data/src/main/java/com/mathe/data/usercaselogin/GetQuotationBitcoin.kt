package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.QuotationRepository

class GetQuotationBitcoin(private val quotationRepository: QuotationRepository) {
    suspend operator fun invoke(): Double {
    return quotationRepository.getBitcoin()
    }
}