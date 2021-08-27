package com.example.firebase_room.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firebase_room.MainActivity
import com.example.firebase_room.ProductsAndCategoryActivity
import com.example.firebase_room.R
import com.example.firebase_room.databinding.MainFragmentBinding
import com.example.firebase_room.utils.replaceFragment
import com.example.firebase_room.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    private val observerUser = Observer<FirebaseUser?> {
        (requireActivity() as? MainActivity)?.chengeScreen()
    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = MainFragmentBinding.bind(view)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        binding.botaoEntrar.setOnClickListener {
            val inputEmail = binding.editTextEmail
            val inputPassword = binding.editTextPassword

            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.accountLogin(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }
    }

}