package com.example.androidgraphql.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidgraphql.domain.model.CountryDetailedModel
import com.example.androidgraphql.domain.model.CountryModel
import com.example.androidgraphql.domain.usecase.GetCountriesUseCase
import com.example.androidgraphql.domain.usecase.GetSelectedCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getSelectedCountryUseCase: GetSelectedCountryUseCase,
) : ViewModel() {

    private val _countryState = MutableStateFlow(CountryUiState())
    val countryState: StateFlow<CountryUiState> = _countryState.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    isLoading = true
                )
            }
            _countryState.update {
                it.copy(
                    isLoading = false,
                    countries = getCountriesUseCase.invoke()
                )
            }
        }
    }

    fun getSelectedCountry(code: String) {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    selectedCountry = getSelectedCountryUseCase.invoke(code)
                )
            }
        }
    }

    fun dismissSelectedDialog() {
        viewModelScope.launch {
            _countryState.update {
                it.copy(selectedCountry = null)
            }
        }
    }
}

data class CountryUiState(
    val isLoading: Boolean = false,
    val countries: List<CountryModel> = emptyList(),
    val selectedCountry: CountryDetailedModel? = null,
)