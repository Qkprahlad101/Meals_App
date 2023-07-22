package com.example.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealzapp.model.response.MealsResponse

@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val imageColor by transition.animateColor(targetValueByState = { it.color }, label = "")
    val imageBorderStroke by transition.animateDp(
        targetValueByState = { it.borderWidth },
        label = ""
    )

    Column() {
        Row() {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = imageBorderStroke,
                    color = imageColor
                )
            ) {
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
                profilePictureState = if (profilePictureState == MealProfilePictureState.Normal) MealProfilePictureState.Expanded else MealProfilePictureState.Normal
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Change State of meal profile picture")
        }

    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 4.dp),
    Expanded(Color.Green, 240.dp, 4.dp)
}