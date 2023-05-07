package com.example.pruebasfirebasekotlin.di

import com.example.pruebasfirebasekotlin.data.repository.AuthenticationRepositoryImpl
import com.example.pruebasfirebasekotlin.domain.repository.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ) : AuthenticationRepository

}