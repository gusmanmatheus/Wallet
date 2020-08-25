package com.example.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.HomeInteractor
import com.mathe.core.interactors.*
import com.mathe.domain.Resources
import com.mathe.domain.Transaction
import com.mathe.domain.User
import com.mathe.domain.Wallet
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class HomeViewModel(
    private val homeInteractor: HomeInteractor
) : ViewModel() {
    private val _bitcoin = MutableLiveData<Double>()
    private val _britta = MutableLiveData<Double>()

    private val _errorBitcoin = MutableLiveData<String>()
    val errorBitcoin: LiveData<String> = _errorBitcoin
    private val _errorBritta = MutableLiveData<String>()
    val errorBritta: LiveData<String> = _errorBritta

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _wallet = MutableLiveData<Wallet>()
    val wallet: LiveData<Wallet> = _wallet

    val selectedTrade = MutableLiveData<String>()
    val exchangeSpent = MutableLiveData<String>()

    private val _convertedExchange = MutableLiveData<String>()
    val convertedExchange: LiveData<String> = _convertedExchange

    private val buyCoin = MutableLiveData<Coins>()
    private val sellCoin = MutableLiveData<Coins>()

    private val _realText = MutableLiveData<String>()
    val realText: LiveData<String> = _realText

    private val _brittaText = MutableLiveData<String>()
    val brittaText: LiveData<String> = _brittaText

    private val _bitcoinText = MutableLiveData<String>()
    val bitcoinText: LiveData<String> = _bitcoinText

    private val _insufficientFunds = MutableLiveData<Boolean>()
    val insufficientFunds: LiveData<Boolean> = _insufficientFunds

    fun getQuotations() {
        viewModelScope.launch {
            val brittaResponse = homeInteractor.getQuotationDollar()
            when (brittaResponse.status) {
                Resources.StatusRequest.SUCCESS -> {
                    _britta.value = brittaResponse.data
                    if (_britta.value == 0.0 || _britta.value == null)
                        _errorBritta.value = "error"
                }
                Resources.StatusRequest.ERROR -> {
                    _errorBritta.value = brittaResponse.error
                }

            }
            val bitcoinResponse = homeInteractor.getQuotationBitcoin()
            when (brittaResponse.status) {
                Resources.StatusRequest.SUCCESS -> {
                    _bitcoin.value = bitcoinResponse.data
                    if (_bitcoin.value == 0.0 || _bitcoin.value == null)
                        _errorBitcoin.value = "error"
                }
                Resources.StatusRequest.ERROR -> {
                    _errorBitcoin.value = bitcoinResponse.error
                }
            }
        }
    }

    fun setValuesCoinsTexts() {
        _realText.value = _wallet.value?.real?.toBigDecimal()?.formatMoneyText()
        _brittaText.value = _wallet.value?.britta?.toBigDecimal()?.formatMoneyText()
        _bitcoinText.value = _wallet.value?.bitcoin?.toString()?.toBigDecimal()?.formatMoneyText()
    }

    fun getUserActive() {
        viewModelScope.launch {
            _user.value = homeInteractor.userActive()
        }
    }

    fun getWallet() {
        viewModelScope.launch {
            _user.value?.id?.let {
                _wallet.value = homeInteractor.getWallet(it)
            }
        }
    }

    fun convertQuotation() {
        when (selectedTrade.value) {
            "converter britta para real" -> {
                brittaToReal()
            }
            "converter bitcoin para britta" -> {
                bitcoinToBritta()
            }
            "converter bitcoin para real" -> {
                bitcoinToReal()
            }
            "converter real para britta" -> {
                realToBritta()
            }
            "converter real para bitcoin" -> {
                realToBitcoin()
            }
            "converter britta para bitcoin" -> {
                brittaToBitcoin()
            }
        }
    }

    private fun brittaToReal() {
        _britta.value?.let {
            _convertedExchange.value =
                exchangeSpent.value.cleanMoneyText().toString().makeConvert(it, 1.0)
            sellCoin.value = Coins.BRITTA
            buyCoin.value = Coins.REAL
        }
    }

    private fun brittaToBitcoin() {
        _britta.value?.let { britta ->
            _bitcoin.value?.let { bitcoin ->
                _convertedExchange.value =
                    exchangeSpent.value.cleanMoneyText().toString().makeConvert(britta, bitcoin)
                sellCoin.value = Coins.BRITTA
                buyCoin.value = Coins.BITCOIN
            }
        }
    }

    private fun realToBritta() {
        _britta.value?.let {
            _convertedExchange.value =
                exchangeSpent.value.cleanMoneyText().toString().makeConvert(1.0, it)
            sellCoin.value = Coins.REAL
            buyCoin.value = Coins.BRITTA
        }
    }

    private fun realToBitcoin() {
        _bitcoin.value?.let {
            _convertedExchange.value =
                exchangeSpent.value.cleanMoneyText().toString().makeConvert(1.0, it)
            sellCoin.value = Coins.REAL
            buyCoin.value = Coins.BITCOIN
        }
    }


    private fun bitcoinToReal() {
        _bitcoin.value?.let {
            _convertedExchange.value =
                exchangeSpent.value.cleanMoneyText().toString().makeConvert(it, 1.0)
            sellCoin.value = Coins.BITCOIN
            buyCoin.value = Coins.REAL
        }
    }

    private fun bitcoinToBritta() {
        _britta.value?.let { britta ->
            _bitcoin.value?.let { bitcoin ->
                _convertedExchange.value =
                    exchangeSpent.value.cleanMoneyText().toString().makeConvert(bitcoin, britta)
                sellCoin.value = Coins.BITCOIN
                buyCoin.value = Coins.BRITTA
            }
        }
    }

    private fun updateCoinsSell(): Boolean {
        when (sellCoin.value) {
            Coins.REAL -> {
                val real = _wallet.value?.real ?: 0.0
                val sellValue = exchangeSpent.value.cleanMoneyText() ?: 0.0
                val newValue = real - sellValue
                return if (newValue >= 0) {
                    _wallet.value?.real = newValue
                    true
                } else false
            }
            Coins.BRITTA -> {
                val britta = _wallet.value?.britta ?: 0.0
                val sellValue = exchangeSpent.value.cleanMoneyText() ?: 0.0
                val newValue = britta - sellValue
                return if (newValue >= 0) {
                    _wallet.value?.britta = newValue
                    true
                } else false
            }
            Coins.BITCOIN -> {
                val bitcoin = _wallet.value?.bitcoin ?: 0.0
                val sellValue = exchangeSpent.value.cleanMoneyText() ?: 0.0
                val newValue = bitcoin - sellValue
                return if (newValue >= 0) {
                    _wallet.value?.bitcoin = newValue
                    true
                } else false
            }
        }
        return false
    }

    private fun updateCoinsBuy(): Boolean {
        when (buyCoin.value) {
            Coins.REAL -> {
                val real = _wallet.value?.real ?: 0.0
                val sellValue = convertedExchange.value.cleanMoneyText() ?: 0.0
                val newValue = real + sellValue
                return if (newValue >= 0) {
                    _wallet.value?.real = newValue
                    true
                } else false
            }
            Coins.BRITTA -> {
                val britta = _wallet.value?.britta ?: 0.0
                val sellValue = convertedExchange.value.cleanMoneyText() ?: 0.0
                val newValue = britta + sellValue
                return if (newValue >= 0) {
                    _wallet.value?.britta = newValue
                    true
                } else false
            }
            Coins.BITCOIN -> {
                val bitcoin = _wallet.value?.bitcoin ?: 0.0
                val sellValue = convertedExchange.value.cleanMoneyText() ?: 0.0
                val newValue = bitcoin + sellValue
                return if (newValue >= 0) {
                    _wallet.value?.bitcoin = newValue
                    true
                } else false
            }
        }
        return false
    }

    fun updateWallet() {
        viewModelScope.launch {
            _wallet.value?.let {
                if (updateCoinsSell() && updateCoinsBuy()) {
                    Log.i("xrl8", "foi")
                    val a = homeInteractor.updateWallet(it)
                    if (a > 0) {
                        setValuesCoinsTexts()
                        val transaction = Transaction(
                            userId = _user.value?.id?:0,
                            buyType = buyCoin.value?.name.orEmpty(),
                            buyValue =  convertedExchange.value.cleanMoneyText(),
                            sellType = sellCoin.value?.name.orEmpty(),
                            sellValue =exchangeSpent.value.cleanMoneyText(),
                            date = Date().getDatePast().brazilPattern()
                        )
                        Log.i("xrl8",transaction.toString())
                        try {
                            homeInteractor.salveTransaction(transaction)
                        } catch (error: Exception) {
                            Log.i("xrl8", error.message ?: "a")
                        }
                    }
                } else {
                    _insufficientFunds.value = true
                }
            }
        }
    }

    fun logout(){
        viewModelScope.launch {
            homeInteractor.logout()
        }
    }
    enum class Coins(val code: Int) {
        REAL(0),
        BRITTA(1),
        BITCOIN(2)
    }
}


