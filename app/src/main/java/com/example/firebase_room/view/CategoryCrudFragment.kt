package com.example.firebase_room.view

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase_room.R
import com.example.firebase_room.adapter.CategoryAdapter
import com.example.firebase_room.databinding.CategoryCrudFragmentBinding
import com.example.firebase_room.model.Category
import com.example.firebase_room.view_model.CategoryCrudViewModel

class CategoryCrudFragment : Fragment(R.layout.category_crud_fragment) {

    private lateinit var binding: CategoryCrudFragmentBinding
    private lateinit var viewModel: CategoryCrudViewModel
    private var selectedCategory: Category? = null

    private val adapter = CategoryAdapter {
        selectedCategory = it
        binding.inputIdTextInputLayout.visibility = VISIBLE
        binding.newButton.visibility = GONE
        setValueToFields(category = it)
    }

    private val observerCategories = Observer<List<Category>> {
        adapter.refresh(it)
        clearFields()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            CategoryCrudViewModel::class.java
        )
        binding = CategoryCrudFragmentBinding.bind(view)
        viewModel.injectContextAndStartDAO(requireContext())
        settingRecyclerView()
        settingForm()
        viewModel.category.observe(viewLifecycleOwner, observerCategories)
        initialData()

    }

    fun initialData() {
        viewModel.getCategories()
        binding.inputIdTextInputLayout.visibility = GONE
    }

    fun settingRecyclerView() {
        binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.categoriesRecyclerView.adapter = adapter
    }

    fun settingForm() {
        binding.newButton.setOnClickListener {
            binding.inputNameTextInputLayout.editText?.let { edit ->
                if (edit.text.isNotEmpty()) {
                    Category(name = edit.text.toString()).let { category ->
                        viewModel.inserCategory(category)
                        clearFields()
                    }
                }
            }
        }
        binding.deleteButton.setOnClickListener {
            selectedCategory?.let {
                viewModel.deletCategory(it)
            }
        }
        binding.editButton.setOnClickListener {
            selectedCategory?.let { selectedCategory ->

                binding.inputNameTextInputLayout.editText?.let { edit ->
                    if (edit.text.isNotEmpty()) {
                        Category(
                            id = selectedCategory.id,
                            name = edit.text.toString()
                        ).let { category ->
                            viewModel.updateCategory(category)
                        }
                    }
                }
            }
        }
    }

    fun clearFields() {
        binding.inputNameTextInputLayout.editText?.setText("")
        binding.inputIdTextInputLayout.editText?.setText("")
        binding.inputIdTextInputLayout.visibility = GONE
        binding.newButton.visibility = VISIBLE
    }

    fun setValueToFields(category: Category) {
        binding.inputIdTextInputLayout.editText?.setText(category.id.toString())
        binding.inputNameTextInputLayout.editText?.setText(category.name)
    }
}