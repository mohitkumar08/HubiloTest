package com.splitwise.launcher

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.core.BaseComponent
import com.core.CoreActivity
import com.signin.data.LoginRepository
import com.splitwise.launcher.di.component.DaggerSplashComponent
import com.splitwise.login.ui.LoginActivity
import com.splitwise.transactionlist.ui.TransactionListActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashActivity : CoreActivity() {
    @Inject
    lateinit var loginRepository: LoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            launch(Dispatchers.IO) {
                if (loginRepository.isUserLogin()) {
                    val userId = loginRepository.getUserId()
                    startActivity(TransactionListActivity.getIntent(this@SplashActivity,userId))
                    finish()
                } else {
                    startActivity(LoginActivity.getIntent(this@SplashActivity))
                    finish()
                }
            }
        }

    }

    override fun setupActivityComponent() {
        DaggerSplashComponent.builder()
            .dependBaseComponent(applicationContext as BaseComponent)
            .build()
            .inject(this)
    }

}