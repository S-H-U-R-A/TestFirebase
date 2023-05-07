package com.example.pruebasfirebasekotlin.data.repository

import com.example.pruebasfirebasekotlin.data.datasource.authentication.AuthenticationDataSource
import com.example.pruebasfirebasekotlin.di.AuthRemoteFirebaseDataSource
import com.example.pruebasfirebasekotlin.domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class AuthenticationRepositoryImpl @Inject constructor(
    @AuthRemoteFirebaseDataSource private val authRemoteDataSource: AuthenticationDataSource
) : AuthenticationRepository {

    override suspend fun registerUser(): Flow<Boolean> = authRemoteDataSource.registerUser()


}