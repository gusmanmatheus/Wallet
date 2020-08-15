package com.mathe.login.presentation

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathe.login.LoginInteractor
import kotlinx.coroutines.launch

class LoginViewModel(val loginInteractor: LoginInteractor) : ViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _error = MutableLiveData<String>()
    val error:LiveData<String> = _error

     private val _goToHomeScreen  = MutableLiveData<Boolean>()
      val goToHomeScreen:LiveData<Boolean> =  _goToHomeScreen

    fun login() {
        this.username.value?.let {
            viewModelScope.launch {
                 val user = loginInteractor.authenticate(
                    username.value.toString(),
                    password.value.toString()
                )

                if(user == null){
                    _error.value = "usuario ou senha incorretos"
                }else {

                    _goToHomeScreen.value = true
                }
            }
        }


    }
}