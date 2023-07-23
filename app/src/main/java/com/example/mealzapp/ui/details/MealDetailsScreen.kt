package com.example.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.example.mealzapp.model.response.MealsResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    val scrollState = rememberScrollState() //to enable scrolling
    val offset = min(1f, 1 - (scrollState.value / 600f)) //to enable image shrinking while scrolling list
    val size by animateDpAsState(targetValue = max(0.dp, 200.dp * offset))
    Surface(color = MaterialTheme.colorScheme.background) {
        Column() {
            Surface(shadowElevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green
                        )
                    ) {
                        AsyncImage(
                            model = meal?.imageUrl,
                            contentDescription = "",
                            modifier = Modifier
                                .size(size)
                        )
                    }
                    Text(
                        meal?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
                Text("This is a text element.", modifier = Modifier.padding(32.dp))
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 4.dp),
    Expanded(Color.Green, 240.dp, 4.dp)
}
