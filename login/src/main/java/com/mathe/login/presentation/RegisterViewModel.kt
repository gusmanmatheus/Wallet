package com.mathe.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathe.domain.User
import com.mathe.domain.Wallet
import com.mathe.login.RegisterInteractor
import kotlinx.coroutines.launch

class RegisterViewModel(val registerInteractor: RegisterInteractor) : ViewModel() {
    val username = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val name = MutableLiveData<String>()

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int> = _error

    private val _goToCongratulationScreen = MutableLiveData<Boolean>()
    val goToCongratulationScreen: LiveData<Boolean> = _goToCongratulationScreen

    init {
        username.value = ""
        password.value = ""
        name.value = ""
    }

    fun registerUser() {
        viewModelScope.launch {
            val idUsername = registerInteractor.findUserId(username.value ?: "")
            if (idUsername == null) {
                val idNewUser = registerInteractor.register(
                    User(
                        username = username.value ?: "",
                        name = name.value ?: username.value ?: "",
                        password = password.value ?: ""
                    )
                )
                if (idNewUser > 0) setSession(idNewUser) else _error.value = 1
            } else {
                _error.value = 2
            }
        }
    }
    private fun setSession(id: Long) {
        viewModelScope.launch {
            if (registerInteractor.login(id) >= 1) {
                _goToCongratulationScreen.value = true
            }
        }
    }
      fun resetRoute(){
        _goToCongratulationScreen.value = false
    }
}

