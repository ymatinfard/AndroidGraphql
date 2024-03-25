package com.example.androidgraphql.domain

data class CountryModel(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String?
)