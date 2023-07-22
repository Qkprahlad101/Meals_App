package com.example.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealzapp.model.response.MealsResponse

@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    var isExpanded by remember{ mutableStateOf(false) }
    val imageSizeDp: Dp by animateDpAsState(targetValue = if (isExpanded) 200.dp else 100.dp)
    Column() {
        Row() {
            Card() {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                meal?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            onClick = {
                      isExpanded = !isExpanded
                      },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Change State of meal profile picture")
        }

    }

}