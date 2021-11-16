package com.signin.data.session

import com.signin.data.model.LoggedInUser

interface UserSessionManager {
    fun isUserLogin():Boolean
    fun logout()
    fun loginUser(loggedInUser: LoggedInUser):Boolean

}