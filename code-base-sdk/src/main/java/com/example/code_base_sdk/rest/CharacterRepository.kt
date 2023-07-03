package com.example.code_base_sdk.rest


import com.example.code_base_sdk.model.domain.DomainChar
import com.example.code_base_sdk.model.domain.mapToDomain
import com.example.code_base_sdk.utils.AppType
import com.example.code_base_sdk.utils.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface CharacterRepository {
    fun getCharacters(type: AppType): Flow<ResultState<List<DomainChar>>>
}

class CharacterRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterRepository {

    override fun getCharacters(type: AppType): Flow<ResultState<List<DomainChar>>> = flow {
        emit(ResultState.Loading)

        try {
            val response = serviceApi.getCharacters(type.endPoint)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ResultState.Success(it.relatedTopics.mapToDomain()))
                }
            }
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }.flowOn(ioDispatcher)


}