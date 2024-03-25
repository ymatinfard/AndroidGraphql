package com.example.androidgraphql.data

import com.apollographql.apollo3.ApolloClient
import com.example.androidgraphql.domain.model.CountryModel
import com.example.androidgraphql.domain.CountryClient
import com.example.androidgraphql.domain.model.CountryDetailedModel
import com.graphql.CountriesQuery
import com.graphql.CountryQuery

class ApolloCountryClient(
    private val apolloClient: ApolloClient,
) : CountryClient {
    override suspend fun getCountries(): List<CountryModel> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map(CountriesQuery.Country::toDomain) ?: emptyList()
    }

    override suspend fun getCountry(code: String): CountryDetailedModel? {
        return apolloClient.query(CountryQuery(code)).execute().data?.country?.toDomain()
    }
}