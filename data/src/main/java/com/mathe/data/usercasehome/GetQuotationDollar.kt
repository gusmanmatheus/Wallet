package com.mathe.data.usercasehome

import com.mathe.data.repository.local.QuotationRepository
import com.mathe.domain.Resources


class GetQuotationDollar(private val quotationRepository: QuotationRepository) {
suspend operator fun invoke(): Resources<Double>? {
    return quotationRepository.getDollar()
}
}