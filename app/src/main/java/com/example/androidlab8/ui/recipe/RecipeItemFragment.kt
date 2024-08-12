package com.example.androidlab8.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab8.databinding.FragmentRecipeItemBinding
import com.example.androidlab8.model.Recipe
import com.example.androidlab8.ui.recipeRecyclerView.RecipeRecyclerAdaptor
import com.example.androidlab8.ui.viewModel.RecipeViewModel

class RecipeItemFragment : Fragment() {
    private lateinit var binding: FragmentRecipeItemBinding
    private lateinit var recipesRecyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeRecyclerAdaptor
    private val viewModel: RecipeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeViewModel()
        viewModel.getRecipes()

    }

    private fun initUI() {
        recipesRecyclerView = binding.recipesRecyclerView
        recipeAdapter = RecipeRecyclerAdaptor(arrayListOf(), communicator)
        recipesRecyclerView.adapter = recipeAdapter
    }

    private fun observeViewModel() {
        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipes?.let {
                recipeAdapter.updateRecipes(it)
            }
        }
    }

    private val communicator = object : RecipeRecyclerAdaptor.Communicator {
        override fun onItemClicked(recipe: Recipe) {
            val action =
                RecipeItemFragmentDirections.actionRecipeItemFragmentToRecipeDetailsFragment(
                    recipe.image!!, recipe.name!!, recipe.description!!
                )
            findNavController().navigate(action)
            Toast.makeText(requireContext(), recipe.name, Toast.LENGTH_SHORT).show()
        }
    }
}