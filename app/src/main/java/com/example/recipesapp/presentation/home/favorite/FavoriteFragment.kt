package com.example.recipesapp.presentation.home.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.recipesapp.databinding.FragmentFavoriteBinding
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.presentation.home.favorite.viewmodel.FavoriteViewModel
import com.example.recipesapp.presentation.home.recipes.RecipesFragmentDirections
import com.example.recipesapp.presentation.home.recipes.adapter.OnItemClick
import com.example.recipesapp.presentation.home.recipes.adapter.RecipesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class FavoriteFragment : Fragment() ,OnItemClick<Meal>{
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private  val recipeAdapter by lazy { RecipesAdapter() }
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipeAdapter.onItemClicked=this
        favoriteViewModel.getAllFavoriteRecipes()
        observe()
        binding.rvRecipes.adapter=recipeAdapter
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            favoriteViewModel.recipeResponse.collect {
                if (it != null) {
                    showRecyclerViewAndHideShimmerEffect()
                    recipeAdapter.updateList(it)
                }

            }

        }
    }
    private fun showRecyclerViewAndHideShimmerEffect() {
        binding.shimmerFrameLayout.visibility = View.GONE
        binding.rvRecipes.visibility = View.VISIBLE
    }

    override fun onItemClicked(item: Meal, position: Int) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToRecipeDetailsFragment(item)
        findNavController().navigate(action)
    }

}