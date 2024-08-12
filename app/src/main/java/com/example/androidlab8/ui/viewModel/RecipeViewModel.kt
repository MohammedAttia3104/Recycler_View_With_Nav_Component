package com.example.androidlab8.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlab8.data.repository.RecipeRepository
import com.example.androidlab8.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val _recipes: MutableLiveData<ArrayList<Recipe>> = MutableLiveData()
    var recipes: MutableLiveData<ArrayList<Recipe>> = _recipes
    private val recipeRepository = RecipeRepository()

    fun getRecipes() {
        viewModelScope.launch {
            recipes.value = recipeRepository.getRecipes()
        }
    }
}