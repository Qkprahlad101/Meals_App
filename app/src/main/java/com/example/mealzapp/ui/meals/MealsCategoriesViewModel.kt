package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealzRepository
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealzRepository = MealzRepository()): ViewModel() {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit){
         repository.getMeals{response ->
            successCallback(response)
         }
    }
}

