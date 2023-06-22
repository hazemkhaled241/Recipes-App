package com.example.recipesapp.presentation.intro.login

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.recipesapp.databinding.FragmentLoginBinding
import com.example.recipesapp.presentation.home.MainActivity
import com.example.recipesapp.presentation.intro.login.viewmodel.LoginState
import com.example.recipesapp.presentation.intro.login.viewmodel.LoginViewModel
import com.example.recipesapp.utils.Constants.Companion.DURATION
import com.example.recipesapp.utils.createAlertDialog
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var dialog: Dialog
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = requireContext().createAlertDialog(requireActivity())

        binding.btnLogin.setOnClickListener {
            loginViewModel.login(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
            observe()
        }
    }

    private fun observe() {
        lifecycleScope.launch {
            loginViewModel.loginState.collect {
                when (it) {
                    LoginState.Init -> Unit
                    is LoginState.IsLoading -> handleLoadingState(it.isLoading)
                    is LoginState.LoginSuccessfully -> {
                        Intent(requireActivity(), MainActivity::class.java).also { intent ->
                            startActivity(intent)
                            requireActivity().finish()
                        }
                    }
                    is LoginState.ShowError -> {
                        handleErrorState(it.message)
                    }

                }
            }
        }
    }

    private fun handleLoadingState(isLoading: Boolean) {
        when (isLoading) {
            true -> {
                startLoadingDialog()
            }
            false -> dismissLoadingDialog()
        }
    }

    private fun startLoadingDialog() {
        dialog.create()
        dialog.show()
    }

    private fun dismissLoadingDialog() {
        dialog.dismiss()
    }

    private fun handleErrorState(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            DURATION
        ).show()
    }

}