package com.example.pruebasfirebasekotlin.di

import com.example.pruebasfirebasekotlin.data.datasource.authentication.AuthenticationDataSource
import com.example.pruebasfirebasekotlin.data.datasource.authentication.AuthenticationRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

//SIRVE COMO INDICADOR DE CUAL INTERFAZ DEVOLVER
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRemoteFirebaseDataSource

//SIRVE COMO INDICADOR DE CUAL INTERFAZ DEVOLVER
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRemoteRoomDataSource


//MEDIANTE UN MÓDULO INDICAMOS A HILT COMO PROPORCIONAR
//INSTANCIAS DE LOS DATASOURCE
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @AuthRemoteFirebaseDataSource
    @Binds
    abstract fun bindRemoteAuthenticationDataSource(
        authenticationRemoteDataSourceImpl: AuthenticationRemoteDataSourceImpl
    ) : AuthenticationDataSource


}