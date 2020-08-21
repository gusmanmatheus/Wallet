package com.mathe.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathe.login.LoginInteractor
import kotlinx.coroutines.launch

class LoginViewModel(val loginInteractor: LoginInteractor) : ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    private val _goToHomeScreen = MutableLiveData<Boolean>()
    val goToHomeScreen: LiveData<Boolean> = _goToHomeScreen

    fun login() {
        viewModelScope.launch {
            val user = loginInteractor.authenticate(
                username.value ?: "",
                password.value ?: ""
            )
            if (user == null) _error.value = true
            else setSession(user.id)
        }
    }

    fun verifyHasSession() {
        viewModelScope.launch {
            val sessionUser = loginInteractor.getActiveUser()
             sessionUser?.let {
                _goToHomeScreen.value = true
            }
        }
    }

    private fun setSession(id: Long) {
        viewModelScope.launch {
            if (loginInteractor.login(id) >= 1){
                _goToHomeScreen.value =  true
            }
        }
    }
}


