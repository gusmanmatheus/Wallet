package com.mathe.data.usercasehome

import com.mathe.data.repository.remote.QuotationRepository
import com.mathe.domain.Resources

class GetQuotationBitcoin(private val quotationRepository: QuotationRepository) {
    suspend operator fun invoke(): Resources<Double?> {
        return quotationRepository.getBitcoin()
    }
}