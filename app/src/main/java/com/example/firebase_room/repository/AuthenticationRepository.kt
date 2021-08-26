package com.example.firebase_room.repository

import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {

    private val authent = FirebaseAuth.getInstance()

    fun singEmailAndPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val tesk = authent.signInWithEmailAndPassword(email, password)
        tesk.addOnSuccessListener { authResult ->
            if (authResult.user != null) {
                callback(authResult.user, null)
            } else {
                callback(null, "Error Login")
            }
        }
        tesk.addOnFailureListener { exception ->
            callback(null, exception.message)
        }
    }

}