package com.example.starbucksfinder.presentation.ui.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.starbucksfinder.R

@Composable
fun ShopRating(rating: Float, textColor: Color) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_star_24),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colors.secondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Rating: $rating",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically),
            color = textColor
        )
    }
}