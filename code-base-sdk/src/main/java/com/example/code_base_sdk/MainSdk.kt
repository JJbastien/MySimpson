package com.example.code_base_sdk

import android.content.Context
import android.content.Intent
import com.example.code_base_sdk.utils.AppType
import com.example.code_base_sdk.views.BaseMainActivity

interface MainSdkInterface {
    fun launchApplication(context: Context, appType: AppType)
}

object MainSdk : MainSdkInterface {
    override fun launchApplication(context: Context, appType: AppType) {
        Intent(context, BaseMainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra("APP_TYPE", appType)
            context.startActivity(this)
        }
    }
}