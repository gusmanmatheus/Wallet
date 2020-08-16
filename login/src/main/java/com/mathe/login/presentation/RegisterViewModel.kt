package com.mathe.login.presentation

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathe.domain.User
import com.mathe.login.LoginInteractor
import kotlinx.coroutines.launch

class RegisterViewModel(val loginInteractor: LoginInteractor) : ViewModel() {
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
            val idUsername = loginInteractor.findUserId(username.value ?: "")
            if (idUsername == null) {
                val idNewUser = loginInteractor.register(
                    User(
                        username.value ?: "",
                        name.value ?: username.value ?: "",
                        password.value ?: ""
                    )
                )
                if (idNewUser > 0) _goToCongratulationScreen.value = true else _error.value = 1
            } else {
                _error.value = 2
            }
        }
    }
}

