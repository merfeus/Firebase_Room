package com.example.firebase_room.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebase_room.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel() {

    private val authrepository = AuthenticationRepository()

    private val _USER = MutableLiveData<FirebaseUser?>()
    val user : LiveData<FirebaseUser?> = _USER

    private val _ERROR = MutableLiveData<String>()
    val error : LiveData<String> = _ERROR

    fun accountLogin (email: String, password: String){
        authrepository.singEmailAndPassword(email, password) { userFirebase, error ->
            if (userFirebase != null){
                _USER.value = userFirebase
            } else{
                _ERROR.value = error ?: "Erro Login"
            }
        }
    }

}