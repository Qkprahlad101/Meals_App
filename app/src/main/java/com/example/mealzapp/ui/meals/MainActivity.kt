package com.example.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.model.response.MealsResponse
import com.example.mealzapp.ui.theme.MealzAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                    MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel : MealsCategoriesViewModel = viewModel()
    val rememberMeals: MutableState<List<MealsResponse>> = remember {
        mutableStateOf(emptyList<MealsResponse>())
    }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS"){
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberMeals.value = meals
        }
    }

    LazyColumn{
        items(rememberMeals.value){ meal ->
            Text(
                text = meal.name
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}