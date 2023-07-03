package com.example.code_base_sdk.viemwodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code_base_sdk.model.domain.DomainChar
import com.example.code_base_sdk.usecase.CharactersUseCase
import com.example.code_base_sdk.utils.AppType
import com.example.code_base_sdk.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainBaseViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : ViewModel() {

    var appType: AppType? = null

    private val _selectedItem: MutableLiveData<DomainChar> = MutableLiveData()
    val selectedItem: LiveData<DomainChar> get() = _selectedItem

    private val _characters: MutableLiveData<ResultState<List<DomainChar>>> = MutableLiveData(ResultState.Loading)
    val characters: LiveData<ResultState<List<DomainChar>>> get() = _characters

    fun setSelectedItem(item: DomainChar) {
        _selectedItem.value = item
    }

    fun getCharacters() {
        appType?.let {
            viewModelScope.launch {
                charactersUseCase(it).collect {
                    _characters.postValue(it)
                }
            }
        } ?: _characters.postValue(ResultState.Error(Exception("NO APP TYPE SELECTED")))
    }

    fun searchItems(newText: String?) {
        newText?.let {

        }
    }

}