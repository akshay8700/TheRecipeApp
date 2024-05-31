package com.akshay8700.therecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState


    // It will fatch data from api exactly when MainViewModel class instance made
    // This means that whenever an instance of this class is created, the fatchCategories() function will be executed automatically.
    init {
        fatchCategories()
    }

    private fun fatchCategories() {
        viewModelScope.launch {
            try {
                // Now accessing data from api getting categories retrofit is doing his work
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                // We are updating categorieState because this holds state of screen and list if
                // list is not fatched he will instead show error on screen error is managed by try and catch
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    // RecipeState is the actually holding actual data list of category that we are getting from
    // api and state of error and loading to
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}