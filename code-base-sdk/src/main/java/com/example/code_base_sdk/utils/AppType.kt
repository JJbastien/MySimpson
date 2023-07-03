package com.example.code_base_sdk.utils

enum class AppType (val endPoint: String) {
    SIMPSONS("?q=simpsons+characters&format=json"),
    THE_WIRE("?q=the+wire+characters&format=json")
}