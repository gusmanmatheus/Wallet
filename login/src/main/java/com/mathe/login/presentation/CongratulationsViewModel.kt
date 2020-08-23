package com.mathe.login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathe.domain.User
import com.mathe.domain.Wallet
import com.mathe.login.CongratulationsInteractor
import kotlinx.coroutines.launch

class CongratulationsViewModel(private val congratulationsInteractor: CongratulationsInteractor) :
    ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _congratsInfo = MutableLiveData<String>()
    val congratsInfo: LiveData<String> = _congratsInfo

    private val _goToHome = MutableLiveData<Boolean>()
    val goToHome: LiveData<Boolean> = _goToHome

    private val _enableClick = MutableLiveData<Boolean>()
    val enableClick: LiveData<Boolean> = _enableClick

    fun loggedUser() {
        viewModelScope.launch {
            _user.value = congratulationsInteractor.getActiveUser()
            Log.i("xrl8", user.value.toString())
            createWallet(user.value?.id ?: 0)
        }
    }

    private fun createWallet(id: Long) {
        viewModelScope.launch {
            val congrats = congratulationsInteractor.createNewWallet(Wallet.create(id))
            Log.i("xrl8", congrats.toString())
            _enableClick.value = true
        }
    }

    fun setCongratsTextInfo(message: String) {
        _congratsInfo.value = message
    }
}