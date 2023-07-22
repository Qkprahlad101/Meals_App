package com.example.mealzapp.model

import android.util.Log
import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealzRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}