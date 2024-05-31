package com.akshay8700.therecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// creating retrofit and builder fun is just helping to build it and baseurl is like kitchen and
// kitchen equipments is like urls that helps to actually access actuall data we need we can also say
// base url as a collection but its different from collection
// Example: www.doraemon.gadgets.torch, So in this example  www.doraemon.gadgets is base url for collection of gadgets
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    // GsonConverterFactory helps to convert that json data into kotlin objects
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// giving ApiService interface to retrofit
val recipeService = retrofit.create(ApiService::class.java)

// interface with special @Get notation function means retrofit we
// parse data and because this suspend fun is returning CategoriesResponse
// When we call this we will get CategoriesResponse as a list if we put this in list because its itself is a list of
//    val idCategory: String,
//    val strCategory: String,
//    val strCategoryThumb: String,
//    val strCategoryDescription: String
interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}