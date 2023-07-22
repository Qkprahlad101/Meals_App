package com.example.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealzRepository
import com.example.mealzapp.model.response.MealsResponse

class MealDetailsViewModel(
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val repository: MealzRepository = MealzRepository.getInstance()
    var mealState = mutableStateOf<MealsResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}