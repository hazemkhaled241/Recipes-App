package com.example.recipesapp.presentation.recipes

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.recipesapp.databinding.FragmentRecipesBinding
import com.example.recipesapp.presentation.recipes.adapter.RecipesAdapter
import com.example.recipesapp.presentation.recipes.viewmodel.RecipesState
import com.example.recipesapp.presentation.recipes.viewmodel.RecipesViewModel
import com.example.recipesapp.utils.createAlertDialog
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipesFragment : Fragment() {
    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private val recipesViewModel: RecipesViewModel by viewModels()
    private lateinit var dialog: Dialog
    private  val recipeAdapter by lazy { RecipesAdapter() }
    private val TAG="RecipesFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = requireContext().createAlertDialog(requireActivity())
        recipesViewModel.fetchAllRecipes()
        observe()
        binding.rvRecipes.adapter=recipeAdapter
    }

    private fun observe() {
        lifecycleScope.launch {
            recipesViewModel.recipesState.collect {
                when (it) {
                    RecipesState.Init -> Unit
                    is RecipesState.IsLoading -> handleLoadingState(it.isLoading)
                    is RecipesState.GetAllRecipesSuccessfully -> {
                        Log.d(TAG, it.meals.toString())
                        showRecyclerViewAndHideShimmerEffect()
                        recipeAdapter.updateList(it.meals)
                    }
                    is RecipesState.ShowError -> {
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
      //  dialog.create()
      //  dialog.show()
    }

    private fun dismissLoadingDialog() {
        //dialog.dismiss()
    }

    private fun handleErrorState(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            2000
        ).show()
    }
    private fun showRecyclerViewAndHideShimmerEffect() {
        binding.shimmerFrameLayout.visibility = View.GONE
        binding.rvRecipes.visibility = View.VISIBLE
    }
}