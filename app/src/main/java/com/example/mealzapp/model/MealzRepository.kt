package com.example.mealzapp.model

import android.util.Log
import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealzRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealsResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealsResponse?{
        return cachedMeals.firstOrNull(){
            it.id == id
        }
    }

    companion object{
        @Volatile
        private var instance: MealzRepository? = null

        fun getInstance() = instance?:synchronized(this){
            instance?: MealzRepository().also { instance = it }
        }
    }
}