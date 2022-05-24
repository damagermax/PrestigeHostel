package com.example.prestigehostel.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.prestigehostel.R
import com.example.prestigehostel.databinding.FragmentSignInBinding
import com.example.prestigehostel.viewmodels.AuthViewModel
import kotlinx.coroutines.launch


/**
 * crated by maxwell takyi on 21 april 2022
 */
class FragmentSignIn : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: String
    private lateinit var password: String

    private val authViewModel:AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtn.setOnClickListener {
            validateFields()
        }
        binding.signUpTx.setOnClickListener {

//            val action =FragmentSignInDirections.actionFragmentSignInToFragmentSignUp()
//            findNavController().navigate(action)
            signOut()
        }
    }

    private fun validateFields() {
        email = binding.emailInputSi.text.toString()
        password = binding.passwordInputSi.text.toString()


        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "EnterFields", Toast.LENGTH_SHORT).show()
        } else {

            signIn(email, password)

        }
    }

    private fun signIn(email: String, password: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val currentUser = authViewModel.signIn(email, password)
                Log.d("max", "mmmmmdksjlfljklfjnkjflkjelfleij ${currentUser.toString()}")
                if (currentUser != null) {

                    val action = FragmentSignInDirections.actionFragmentSignInToFragmentDashboard()
                findNavController().navigate(action)
                }

            } catch (e: Exception) {
                Toast.makeText(requireContext(), e.localizedMessage, Toast.LENGTH_LONG).show()
            }


        }
    }

    fun signOut(){

            viewLifecycleOwner.lifecycleScope.launch {
                val signOut= authViewModel.logOut()
                if (signOut){
                    Toast.makeText(requireContext(),"signOut SUCCESSFUL",Toast.LENGTH_LONG).show()


                }else Toast.makeText(requireContext(),"signOut failure",Toast.LENGTH_LONG).show()
            }


    }

}