package com.elnaggar.uitestdemoviews

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.elnaggar.uitestdemoviews.databinding.LoginFragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text
            val password = binding.passwordEditText.text

            val isValidEmail = email.isValidEmail()
            if (isValidEmail && password.isNotEmpty()) {
                binding.emailEditText.setText("")
                binding.passwordEditText.setText("")
            } else {
                Toast.makeText(requireContext(), "not valid input", Toast.LENGTH_SHORT).show()
            }

        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}