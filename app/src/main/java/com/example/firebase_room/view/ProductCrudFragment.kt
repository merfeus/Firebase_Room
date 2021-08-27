package com.example.firebase_room.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.firebase_room.R
import com.example.firebase_room.view_model.ProductCrudViewModel

class ProductCrudFragment : Fragment() {

    companion object {
        fun newInstance() = ProductCrudFragment()
    }

    private lateinit var viewModel: ProductCrudViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_crud_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this).get(ProductCrudViewModel::class.java)

    }

}