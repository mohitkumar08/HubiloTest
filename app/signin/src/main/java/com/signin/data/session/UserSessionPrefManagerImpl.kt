package com.signin.data.session

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.signin.data.model.LoggedInUser
import javax.inject.Inject

const val PREF_USER_SESSION = "user_session"

internal class UserSessionPrefManagerImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
    ) : UserSessionManager {
    override fun isUserLogin(): Boolean {
        return sharedPreferences.contains(PREF_USER_SESSION)
    }

    override fun logout() {
       sharedPreferences.edit {
           remove(PREF_USER_SESSION)
           apply()
       }
    }

    override fun loginUser(loggedInUser: LoggedInUser): Boolean {
       return sharedPreferences.edit().putString(PREF_USER_SESSION, gson.toJson(loggedInUser)).commit()
    }
}