package com.example.starbucksfinder.presentation.ui.shoplist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starbucksfinder.R
import com.example.starbucksfinder.presentation.ui.shoplist.ShopListViewModel

@Composable
fun ShopsListScreen(viewModel: ShopListViewModel, navController: NavController) {
    val state = viewModel.state
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            item{
                Image(
                    painter = painterResource(id = R.drawable.ic_starbucks_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .size(60.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            state.shops?.let { shops ->
                itemsIndexed(shops) { index, shop ->
                    if (viewModel.shouldFetchMoreShops(index))
                        viewModel.loadNextShops()
                    ShopItem(
                        shop,
                        navController,
                        index
                    )
                    Divider(modifier = Modifier.height(1.dp))
                }
                item {
                    if (state.isLoading) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }

        }

    }
}
