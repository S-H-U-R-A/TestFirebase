package com.example.pruebasfirebasekotlin.data.datasource.authentication

import kotlinx.coroutines.flow.Flow

interface AuthenticationDataSource {

    suspend fun registerUser() : Flow<Boolean>

}