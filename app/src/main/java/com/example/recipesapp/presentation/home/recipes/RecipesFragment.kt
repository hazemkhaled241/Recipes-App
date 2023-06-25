package com.example.recipesapp.presentation.home.recipes

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.recipesapp.databinding.FragmentRecipesBinding
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.presentation.home.recipes.adapter.OnItemClick
import com.example.recipesapp.presentation.home.recipes.adapter.RecipesAdapter
import com.example.recipesapp.presentation.home.recipes.viewmodel.RecipesState
import com.example.recipesapp.presentation.home.recipes.viewmodel.RecipesViewModel
import com.example.recipesapp.utils.Constants.Companion.DURATION
import com.example.recipesapp.utils.createAlertDialog
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipesFragment : Fragment(), OnItemClick<Meal> {
    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private val recipesViewModel: RecipesViewModel by viewModels()
    private lateinit var dialog: Dialog
    private  val recipeAdapter by lazy { RecipesAdapter() }
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
        recipeAdapter.onItemClicked=this
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
                    is RecipesState.GetAllRecipesSuccessfully -> {
                        recipeAdapter.updateList(it.meals)
                    }
                    is RecipesState.ShowError -> {
                        handleErrorState(it.message)
                    }
                    is RecipesState.IsLoading -> handleLoadingState(it.isLoading)
                }
            }
        }
    }


    private fun handleErrorState(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            DURATION
        ).show()
    }
    private fun showRecyclerViewAndHideShimmerEffect() {
        binding.shimmerFrameLayout.visibility = View.GONE
        binding.rvRecipes.visibility = View.VISIBLE
    }

    override fun onItemClicked(item: Meal, position: Int) {
        val action = RecipesFragmentDirections.actionRecipesFragmentToRecipeDetailsFragment(item)
        findNavController().navigate(action)
    }
    private fun handleLoadingState(isLoading: Boolean) {
        when (isLoading) {
            true -> Unit
            false -> showRecyclerViewAndHideShimmerEffect()
        }
    }
}