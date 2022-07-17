package com.example.starbucksfinder.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = starbucksGreen,
    primaryVariant = starbucksGreen,
    secondary = starbucksYellow,
    background = starbucksBlack,
    surface = starbucksBlack,
    onPrimary = starbucksBlack,
    onSecondary = starbucksBlack,
    onBackground = starbucksWhite,
    onSurface = starbucksWhite,

    )

@Composable
fun StarbucksFinderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}