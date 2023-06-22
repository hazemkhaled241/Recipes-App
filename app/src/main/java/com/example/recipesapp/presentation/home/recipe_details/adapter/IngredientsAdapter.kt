package com.example.recipesapp.presentation.home.recipe_details.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.databinding.IngredientsItemBinding

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {
    private var ingredients: ArrayList<String> = arrayListOf()

    inner class MyViewHolder(private val binding: IngredientsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: String) {
            binding.ingredients.text = ingredient
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            IngredientsItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(
            ingredients[position]
        )
    }
    @SuppressLint("notifyDataSetChanged")
    fun updateList(newList:ArrayList<String>){
        this.ingredients=newList
        notifyDataSetChanged()
    }
}