package com.example.code_base_sdk.rest

import com.example.code_base_sdk.utils.JSON_FORMAT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET()
    suspend fun getCharacters(
        @Query("q") type: String,
        @Query("format") format: String = JSON_FORMAT
    ): Response<com.example.code_base_sdk.model.Character>
}