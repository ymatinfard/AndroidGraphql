package com.example.androidgraphql.domain.usecase

import com.example.androidgraphql.domain.CountryClient

class GetSelectedCountryUseCase(
    private val client: CountryClient
) {
    suspend fun invoke(code: String) = client.getCountry(code)
}