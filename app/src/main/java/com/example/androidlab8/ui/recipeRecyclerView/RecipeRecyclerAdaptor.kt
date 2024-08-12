package com.example.androidlab8.ui.recipeRecyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidlab8.R
import com.example.androidlab8.databinding.SingleItemBinding
import com.example.androidlab8.model.Recipe

class RecipeRecyclerAdaptor(
    private var recipes: ArrayList<Recipe>,
    private val communicator: Communicator
) : RecyclerView.Adapter<RecipeRecyclerAdaptor.RecipeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
        val binding = SingleItemBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_item, parent, false)
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.bind(currentRecipe)
        holder.itemView.setOnClickListener {
            communicator.onItemClicked(currentRecipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecipes(newRecipes: ArrayList<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }

    class RecipeViewHolder(private val binding: SingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.recipeTitleTextView.text = recipe.name
            binding.recipeHeaderTextView.text = recipe.headline
            binding.recipeTimerTextView.text = recipe.time
            binding.recipeCaloriesTextView.text = recipe.calories
            Glide.with(itemView.context).load(recipe.image).into(binding.recipeImageView)
        }
    }

    interface Communicator {
        fun onItemClicked(recipe: Recipe)
    }
}