package com.akshay8700.therecipeapp

// Creating this because json is gonna we same just like this CategoriesResponse is [list in json] and Category is
// {objects in json} and all those var are properties in json gson builder will convert in this form exactly
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class CategoriesResponse(
    val categories: List<Category>
)