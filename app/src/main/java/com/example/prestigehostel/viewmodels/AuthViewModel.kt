package com.example.prestigehostel.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


const val TAG = "MAXWELL"

class AuthViewModel : ViewModel() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()


    suspend fun signUp(email: String, password: String): FirebaseUser? {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Log.d(TAG, "current user   $user")


                } else {

                    // If sign in fails, display a message to the user.
                    Log.d(TAG, "createUserWithEmail:failure", task.exception)


                }
            }

        return auth.currentUser
    }


    suspend fun signIn(email: String, password: String): FirebaseUser? {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    Log.d(TAG, "signInWithEmail:success  USER: $user")


                } else {
                    // If sign in fails, display a message to the user.
                    Log.d(TAG, "signInWithEmail:failure", task.exception)


                }
            }


        return auth.currentUser
    }

    suspend fun logOut(): Boolean {

        var isSignOut = false
        auth.signOut()
        isSignOut = true

        return isSignOut
    }

}