package com.akshay8700.therecipeapp

sealed class Screen(val route:String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}