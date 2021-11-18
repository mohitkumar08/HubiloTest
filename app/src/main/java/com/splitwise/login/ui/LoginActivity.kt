package com.splitwise.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.core.BaseComponent
import com.core.CoreActivity
import com.splitwise.databinding.ActivityLoginBinding
import com.splitwise.login.di.component.DaggerLoginComponent
import javax.inject.Inject

class LoginActivity : CoreActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        addObserver()

        binding.login.setOnClickListener {
            loginViewModel.login(binding.username.text.toString(), binding.password.text.toString())
        }
    }

    override fun setupActivityComponent() {
        DaggerLoginComponent.builder()
            .dependBaseComponent(applicationContext as BaseComponent)
            .build()
            .inject(this)
    }

    private fun addObserver() {
        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            if (loginState.usernameError != null) {
                binding.username.error = getString(loginState.usernameError)
                return@Observer
            }
            if (loginState.passwordError != null) {
                binding.password.error = getString(loginState.passwordError)
                return@Observer
            }


        })

    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
