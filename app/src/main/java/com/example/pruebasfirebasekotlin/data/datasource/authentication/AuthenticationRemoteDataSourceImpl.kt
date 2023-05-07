package com.example.pruebasfirebasekotlin.data.datasource.authentication

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val fireBaseAuth: FirebaseAuth
) : AuthenticationDataSource {

    override suspend fun registerUser(): Flow<Boolean> = flow {

        //TODO("ACÁ SE DEBE USAR FIREBASE AUTH")
        delay(3000)
        emit(true)

    }

}