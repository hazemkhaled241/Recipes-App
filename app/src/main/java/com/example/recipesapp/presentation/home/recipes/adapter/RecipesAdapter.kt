package com.example.recipesapp.presentation.home.recipes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipesapp.R
import com.example.recipesapp.databinding.RecipeItemBinding
import com.example.recipesapp.domain.model.Meal

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {
   private var meals: List<Meal> = emptyList()
    var onItemClicked: OnItemClick<Meal>? =null
    inner class MyViewHolder(private val binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal, position: Int) {
            binding.tvRecipeName.text = meal.name
            binding.tvCarbValue.text = meal.carbos
            binding.tvCaloriesValue.text = meal.calories
            binding.tvFatsValue.text = meal.fats
            binding.ivRecipe.load(meal.image) {
                placeholder(R.drawable.iv_plate)
            }
            binding.cvRecipe.setOnClickListener {
                onItemClicked?.onItemClicked(meal,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecipeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(meals[position], position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newListOfMeals: List<Meal>) {
        this.meals = newListOfMeals
        notifyDataSetChanged()
    }
}