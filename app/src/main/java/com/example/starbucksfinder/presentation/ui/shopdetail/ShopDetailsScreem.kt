package com.example.starbucksfinder.presentation.ui.shopdetail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.starbucksfinder.domain.model.Location
import com.example.starbucksfinder.domain.model.StarbucksShop
import com.example.starbucksfinder.domain.model.Viewport
import com.example.starbucksfinder.presentation.ui.base.ShopOpenState
import com.example.starbucksfinder.presentation.ui.base.ShopRating
import com.example.starbucksfinder.presentation.ui.shoplist.ShopListState
import com.example.starbucksfinder.presentation.ui.shoplist.ShopListViewModel

@Composable
fun ShopDetailsScreen(
    shopsListViewModel: ShopListViewModel = hiltViewModel(),
    shopIndex: Int?
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            val shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, MaterialTheme.colors.primary, shape),
                backgroundColor = MaterialTheme.colors.onBackground,
                shape = shape
            ) {
                shopsListViewModel.state.shops?.let { shops ->
                    shopIndex?.let { index ->
                        val shop = shops[index]
                        Column(modifier = Modifier.padding(16.dp)) {
                            Box(
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = shop.address ?: "",
                                    style = MaterialTheme.typography.h6,
                                    color = MaterialTheme.colors.background
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                shop.rating?.let {
                                    ShopRating(
                                        rating = it,
                                        MaterialTheme.colors.background
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                shop.isOpen?.let { open ->
                                    ShopOpenState(open, MaterialTheme.colors.background)
                                }
                            }

                        }
                    }
                }
            }
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp)),
        ) {
            shopsListViewModel.state.shops?.let { shops ->
                shopIndex?.let { index ->
                    val shop = shops[index]
                    shop.location?.let { loc ->
                        ShopMap(
                            location = loc,
                        )
                    }

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewShopDetailScreen(viewModel: ShopListViewModel = hiltViewModel()) {
    viewModel.state = ShopListState(
        shops = listOf(
            StarbucksShop(
                "OPERATING",
                "Santa fe 4356, CABA, Argentina",
                true,
                Location(2.0, 3.0),
                Viewport(
                    southwest = Location(2.0, 3.0),
                    northeast = Location(2.0, 3.0)
                ),
                4.4f
            )
        )
    )
    ShopDetailsScreen(
        viewModel,
        0
    )
}