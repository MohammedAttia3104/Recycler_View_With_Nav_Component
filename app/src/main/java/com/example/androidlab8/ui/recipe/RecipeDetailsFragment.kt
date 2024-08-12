package com.example.androidlab8.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.example.androidlab8.R
import com.example.androidlab8.databinding.FragmentRecipeDetailsBinding

class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding
    private val args: RecipeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipeDetailsTitleTextView.text = args.recipeTitle
        binding.recipeDetailsDescriptionTextView.text = args.recipeDescription
        Glide.with(this).load(args.recipeImage).into(binding.recipeDetailsImageView)
    }

}