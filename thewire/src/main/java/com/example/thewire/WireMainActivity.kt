package com.example.thewire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.code_base_sdk.MainSdk
import com.example.code_base_sdk.utils.AppType

class WireMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wire_main)
        MainSdk.launchApplication(applicationContext, AppType.THE_WIRE)
    }
}