package com.example.androidgraphql.data

import com.example.androidgraphql.domain.CountryDetailedModel
import com.example.androidgraphql.domain.CountryModel
import com.example.androidgraphql.domain.LanguageModel
import com.graphql.CountriesQuery
import com.graphql.CountryQuery

fun CountriesQuery.Country.toDomain(): CountryModel {
    return CountryModel(code, name, emoji, capital)
}

fun CountryQuery.Country.toDomain(): CountryDetailedModel {
    return CountryDetailedModel(code, name, emoji, capital.orEmpty(), languages.map { it.toDomain() }, continent.name)
}

fun CountryQuery.Language.toDomain(): LanguageModel {
    return LanguageModel(name)
}