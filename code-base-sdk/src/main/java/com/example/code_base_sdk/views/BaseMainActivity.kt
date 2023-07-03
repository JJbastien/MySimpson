package com.example.code_base_sdk.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.code_base_sdk.R
import com.example.code_base_sdk.utils.AppType
import com.example.code_base_sdk.viemwodel.MainBaseViewModel

class BaseMainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[MainBaseViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_main)

        viewModel.appType = intent.getSerializableExtra("APP_TYPE") as AppType

        val host = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

        setupActionBarWithNavController(host.navController)
    }
}