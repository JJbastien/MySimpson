package com.example.code_base_sdk.model


import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

data class Icon(
    @SerializedName("Height")
    val height: String? = null,
    @SerializedName("URL")
    val uRL: String? = null,
    @SerializedName("Width")
    val width: String? = null
)






suspend fun main() {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    scope.launch { error("first coroutine") }.join()
    scope.launch { error("first coroutine") }.join()

    println(scope.isActive)
}






