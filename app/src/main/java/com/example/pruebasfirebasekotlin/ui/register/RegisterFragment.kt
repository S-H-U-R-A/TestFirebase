package com.example.pruebasfirebasekotlin.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.pruebasfirebasekotlin.R
import com.example.pruebasfirebasekotlin.core.ext.showDialogInfo
import com.example.pruebasfirebasekotlin.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initListeners()

    }

    private fun initListeners() {
        binding.btnRegister.setOnClickListener {
            viewModel.register()
        }
    }

    private fun initObservers() {

        //SE ESCUCHA EL ESTADO
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState
                    .collect{ state ->
                        handleLoading( state.isLoading )
                        handleNavigationBack( state.isSuccess, state.userMessage )
                    }
            }
        }

    }

    private fun handleLoading(isVisible: Boolean) {
        with(binding){
            if (isVisible) {

                btnRegister.text = ""
                btnRegister.isEnabled = !isVisible
                piRegister.isVisible = isVisible

            } else {
                piRegister.isVisible = isVisible
                btnRegister.text = getString(R.string.register)
                btnRegister.isEnabled = !isVisible
            }
        }



        binding.piRegister.isVisible = isVisible
    }

    private fun handleNavigationBack(isValidate:Boolean, message: String) {
        if(isValidate){
            showDialogInfo(
                R.style.AlertDialogInfo,
                "Información",
                R.string.positiveButtonInfo,
                { _, _ ->
                    findNavController().popBackStack()
                },
                message
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}