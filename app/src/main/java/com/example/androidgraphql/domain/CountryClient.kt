package com.example.androidgraphql.domain


interface CountryClient {
    suspend fun getCountries(): List<CountryModel>
    suspend fun getCountry(code: String): CountryDetailedModel?
}