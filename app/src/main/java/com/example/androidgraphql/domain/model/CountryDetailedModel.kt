package com.example.androidgraphql.domain.model


data class CountryDetailedModel(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
    val language: List<LanguageModel>,
    val continent: String
)

data class LanguageModel(
    val name: String
)