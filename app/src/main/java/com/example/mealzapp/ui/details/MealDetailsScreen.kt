package com.example.mealzapp.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealzapp.model.response.MealsResponse

@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    Column() {
        Row() {
            Card() {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(meal?.name ?: "default name")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Change State of meal profile picture")
        }

    }

}