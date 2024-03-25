package com.example.androidgraphql.domain

import com.example.androidgraphql.domain.model.CountryDetailedModel
import com.example.androidgraphql.domain.model.CountryModel


interface CountryClient {
    suspend fun getCountries(): List<CountryModel>
    suspend fun getCountry(code: String): CountryDetailedModel?
}