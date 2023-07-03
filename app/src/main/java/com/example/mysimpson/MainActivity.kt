package com.example.mysimpson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.code_base_sdk.MainSdk
import com.example.code_base_sdk.utils.AppType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainSdk.launchApplication(applicationContext, AppType.SIMPSONS)
    }
}