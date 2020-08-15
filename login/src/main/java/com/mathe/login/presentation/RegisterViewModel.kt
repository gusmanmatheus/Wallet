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

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _goToCongratulationScreen = MutableLiveData<Boolean>()
      val goToCongratulationScreen: LiveData<Boolean> = _goToCongratulationScreen
    fun registerUser() {
        viewModelScope.launch {
            username.value?.let { username ->
                val idUsername = loginInteractor.findUserId(username)
                if (idUsername == null) {
                    password.value?.let { password ->
                        val idNewUser = loginInteractor.register(
                            User(
                                username,
                                name.value ?: username,
                                password
                            )
                        )
                        if (idNewUser > 0) _goToCongratulationScreen.value =
                            true else _error.value = "error"
                    } ?: run { _error.value = "Password vazio" }
                } else {
                    _error.value = "Username ja cadastrado"
                }
            } ?: run { _error.value = "Username vazio" }
        }
    }

}