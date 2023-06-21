package com.example.recipesapp.presentation.home.recipe_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentRecipeDetailsBinding
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.presentation.home.recipe_details.viewmodel.RecipeDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeDetailsFragment : Fragment() {
    private var _binding: FragmentRecipeDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: RecipeDetailsFragmentArgs by navArgs()
    private var isFavorite: Boolean? = false
    private var favoriteRecipes: List<Meal> = emptyList()
    private val recipeDetailsViewModel: RecipeDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivFavorite.setOnClickListener {
            handleIsFavorite()
        }
        recipeDetailsViewModel.getAllFavoriteRecipes()
        observe()
    }

    private fun isFavouriteAd(favoriteRecipes: List<Meal>) {
        val result = favoriteRecipes.filter {
            it.id.equals(args.meal.id)
        }
        if (result.isNotEmpty()) {
            isFavorite = true
            binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24)
        }

    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            recipeDetailsViewModel.recipeResponse.collect {
                if (it != null) {
                    favoriteRecipes = it
                    isFavouriteAd(it)
                }

            }

        }
    }

    private fun handleIsFavorite() {
        isFavorite?.let { isFav ->
            isFavorite = !isFav
            if (!isFav) {
                binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24)
                addToFavorite(args.meal)
            } else {
                binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                removeFromFavorite(args.meal)
            }
        }
    }
    private fun removeFromFavorite(meal: Meal) {
        recipeDetailsViewModel.deleteFromFavorite(meal)
    }

    private fun addToFavorite(meal: Meal) {
        recipeDetailsViewModel.addToFavorite(meal)
    }

}