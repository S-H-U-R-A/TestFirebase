package com.example.pruebasfirebasekotlin.ui.register


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebasfirebasekotlin.domain.usecases.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUserUseCase
) : ViewModel() {

    private var _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow( RegisterUiState() )
    val uiState = _uiState.asStateFlow()

    fun register() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            try {

                registerUseCase().onEach { isSuccess ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccess = isSuccess,
                            userMessage = "Registro exitoso"
                        )
                    }
                }.launchIn(viewModelScope)

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        userMessage = e.message.toString()
                    )
                }
                
            }
        }
    }
/*
    fun uiStateWhenNavigate() {
        _uiState.value = RegisterUiState()
    }*/

}

//STATES OF REGISTER LAYOUT
data class RegisterUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val userMessage: String = ""
)

