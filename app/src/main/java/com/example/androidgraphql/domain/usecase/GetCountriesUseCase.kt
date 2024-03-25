package com.example.androidgraphql.domain.usecase

import com.example.androidgraphql.domain.CountryClient

class GetCountriesUseCase (
    private val client: CountryClient
) {
    suspend fun invoke() = client.getCountries().sortedBy { it.name }
}