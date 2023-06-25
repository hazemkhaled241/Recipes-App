package com.example.recipesapp.presentation.home.recipe_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentRecipeDetailsBinding
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.presentation.home.recipe_details.adapter.IngredientsAdapter
import com.example.recipesapp.presentation.home.recipe_details.viewmodel.FavoriteState
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
    private val ingredientsAdapter by lazy { IngredientsAdapter() }
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
        binding.rvIngredients.adapter = ingredientsAdapter
        setMealDate()
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun isFavouriteAd(favoriteRecipes: List<Meal>) {
        val result = favoriteRecipes.filter {
            it.id == args.meal.id
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

    private fun setMealDate() {
        binding.ivRecipe.load(args.meal.image) {
            placeholder(R.drawable.iv_plate)
        }
        ingredientsAdapter.updateList(args.meal.ingredients)
        binding.tvName.text = args.meal.name
        binding.tvRateValue.text = args.meal.rating
        binding.tvRatingsValue.text = args.meal.ratings
        binding.tvCountryValue.text = args.meal.country
        binding.tvFatsValue.text = args.meal.fats
        binding.tvCarbValue.text = args.meal.carbos
        binding.tvCaloriesValue.text = args.meal.calories
        binding.tvProteinsValue.text = args.meal.proteins
        binding.tvFibersValue.text = args.meal.fibers
        binding.tvRecipeDescription.text = args.meal.description
    }

    private fun handleIsFavorite() {
        isFavorite?.let { isFav ->
            isFavorite = !isFav
            if (!isFav)
                addToFavorite(args.meal)
            else
                removeFromFavorite(args.meal)
            observeOnFavoriteState()
        }
    }

    private fun observeOnFavoriteState() {
        viewLifecycleOwner.lifecycleScope.launch {
            recipeDetailsViewModel.favoriteResponse.collect() {
                when (it) {
                    is FavoriteState.AddedSuccessfully -> binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_24)

                    is FavoriteState.DeletedSuccessfully -> binding.ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
                    FavoriteState.Init -> Unit
                    is FavoriteState.ShowError -> Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
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