package com.example.pruebasfirebasekotlin.domain.repository

import kotlinx.coroutines.flow.Flow


interface AuthenticationRepository {

    suspend fun registerUser() : Flow<Boolean>

}