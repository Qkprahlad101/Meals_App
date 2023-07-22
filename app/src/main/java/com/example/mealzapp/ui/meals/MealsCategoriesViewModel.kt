package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealzRepository
import com.example.mealzapp.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealzRepository = MealzRepository()) :
    ViewModel() {

    suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}

