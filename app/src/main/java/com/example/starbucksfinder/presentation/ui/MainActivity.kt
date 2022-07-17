package com.example.starbucksfinder.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.starbucksfinder.presentation.ui.navigation.Navigation
import com.example.starbucksfinder.presentation.ui.navigation.Screen
import com.example.starbucksfinder.presentation.ui.shoplist.ShopListViewModel
import com.example.starbucksfinder.presentation.ui.shoplist.view.ShopsListScreen
import com.example.starbucksfinder.presentation.ui.theme.StarbucksFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ShopListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadNextShops()
        setContent {
            StarbucksFinderTheme {
                Navigation(
                    navController = rememberNavController(),
                )
            }

        }
    }
}
