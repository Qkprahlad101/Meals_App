package com.example.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.model.MealzRepository
import com.example.mealzapp.model.response.MealsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealzRepository = MealzRepository.getInstance()) :
    ViewModel() {

    val mealsState: MutableState<List<MealsResponse>> = mutableStateOf(emptyList<MealsResponse>())
    init{
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    private suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}

