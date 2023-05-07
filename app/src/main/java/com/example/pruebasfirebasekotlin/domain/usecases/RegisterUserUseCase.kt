package com.example.pruebasfirebasekotlin.domain.usecases

import com.example.pruebasfirebasekotlin.domain.repository.AuthenticationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class RegisterUserUseCase @Inject constructor(
    private val authRepository: AuthenticationRepository/*,
    private val dispatcher: CoroutineDispatcher*/
) {

    //Cambiamos la ejecución de la corrutina, aunque creo que acá no se debe hacer
    suspend operator fun invoke(): Flow<Boolean> {
        return authRepository.registerUser()
            //.flowOn(dispatcher)
            .flowOn( Dispatchers.IO )
    }

}