package com.example.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.ReceiptInteractor
import com.mathe.domain.Transaction
import kotlinx.coroutines.launch

class ReceiptViewModel(private val receiptInteractor: ReceiptInteractor) : ViewModel() {
    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions :LiveData<List<Transaction>> = _transactions
    fun getTransactions() {
        viewModelScope.launch {
            val user = receiptInteractor.getActiveUser()
           _transactions.value =  receiptInteractor.getAllTransactions(user?.id ?: 0)
        }
    }
}