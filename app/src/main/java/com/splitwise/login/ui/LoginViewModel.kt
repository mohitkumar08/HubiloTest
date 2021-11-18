package com.splitwise.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.signin.data.LoginRepository
import com.splitwise.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var loginRepository: LoginRepository

    private val _loginForm = MutableLiveData<LoginState>()
    val loginFormState: LiveData<LoginState> = _loginForm

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isUserNameValid(username).not()) {
                _loginForm.value = LoginState(usernameError = R.string.invalid_username)
            } else if (isPasswordValid(password).not()) {
                _loginForm.value = LoginState(passwordError = R.string.invalid_password)
            } else {
                loginRepository.login(username, password).collectLatest {
                    _loginForm.value = LoginState(isDataValid = it)
                }
            }
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}