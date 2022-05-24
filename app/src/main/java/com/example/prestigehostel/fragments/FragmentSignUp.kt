package com.example.prestigehostel.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.prestigehostel.R
import com.example.prestigehostel.databinding.FragmentSignUpBinding

import com.example.prestigehostel.viewmodels.AuthViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

/*
* created by maxwell takyi on 21 april 2022
* */
class FragmentSignUp : Fragment(R.layout.fragment_sign_up) {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.signUpBtn.setOnClickListener {

            Toast.makeText(requireContext(), "maxwell", Toast.LENGTH_SHORT).show()
            signUp("masdlnnelnkr@gmail.com", "kjdfninaijwfnpnfoiae")
        }

        binding.signInTx.setOnClickListener {
            val action =FragmentSignUpDirections.actionFragmentSignUpToFragmentSignIn()
            findNavController().navigate(action)
        }


    }

    private fun signUp(email: String, password: String) {

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val currentUser= authViewModel.signUp(email, password)
                Log.d("maxp", "mmmmmdksjlfljklfjnkjflkjelfleij $currentUser.toString()")

                if (currentUser!=null) {
                    val action = FragmentSignUpDirections.actionFragmentSignUpToFragmentDashboard()
                    findNavController().navigate(action)

                }

            } catch (
                e: Exception
            ) {

            }
        }

    }


    // to avoid memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}