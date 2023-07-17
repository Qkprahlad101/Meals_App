package com.example.mealzapp.model

import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealzRepository {
    fun getMeals() : MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}