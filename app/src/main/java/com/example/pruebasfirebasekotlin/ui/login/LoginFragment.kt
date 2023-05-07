package com.example.pruebasfirebasekotlin.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pruebasfirebasekotlin.R
import com.example.pruebasfirebasekotlin.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

    }

    private fun initListeners() {
        binding.btnRegister.setOnClickListener {
            val actionRegister: NavDirections = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            requireView().findNavController().navigate( actionRegister )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}