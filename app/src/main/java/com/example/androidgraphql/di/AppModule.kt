package com.example.androidgraphql.di

import com.apollographql.apollo3.ApolloClient
import com.example.androidgraphql.data.ApolloCountryClient
import com.example.androidgraphql.domain.usecase.GetCountriesUseCase
import com.example.androidgraphql.domain.usecase.GetSelectedCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGraphqlClient(): ApolloClient =
        ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/graphql").build()

    @Provides
    fun provideCountryClient(client: ApolloClient) = ApolloCountryClient(client)

    @Provides
    fun providesGetCountriesUseCase(apolloCountryClient: ApolloCountryClient): GetCountriesUseCase =
        GetCountriesUseCase(apolloCountryClient)

    @Provides
    fun provideGetSelectedCountryUseCase(apolloCountryClient: ApolloCountryClient): GetSelectedCountryUseCase =
        GetSelectedCountryUseCase(apolloCountryClient)
}