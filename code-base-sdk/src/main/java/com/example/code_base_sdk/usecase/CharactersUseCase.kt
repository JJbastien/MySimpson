package com.example.code_base_sdk.usecase


import com.example.code_base_sdk.model.domain.DomainChar
import com.example.code_base_sdk.rest.CharacterRepository
import com.example.code_base_sdk.utils.AppType
import com.example.code_base_sdk.utils.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(appType: AppType): Flow<ResultState<List<DomainChar>>> =
        repository.getCharacters(appType)
}