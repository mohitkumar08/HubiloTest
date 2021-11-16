package com.signin.data

import com.signin.data.model.LoggedInUser
import com.signin.data.session.UserSessionManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginSessionManager: UserSessionManager) {

    fun login(username: String, password: String): Flow<Boolean> = flow {
        val status = loginSessionManager.loginUser(LoggedInUser(username, password))
        emit(status)
    }

    fun logout() {
        loginSessionManager.logout()
        return
    }
    fun isUserLogin(): Boolean {
        return loginSessionManager.isUserLogin()
    }

}

