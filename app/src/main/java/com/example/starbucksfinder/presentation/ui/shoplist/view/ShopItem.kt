package com.example.starbucksfinder.presentation.ui.shoplist.view

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starbucksfinder.R
import com.example.starbucksfinder.domain.model.StarbucksShop
import com.example.starbucksfinder.presentation.ui.base.ShopOpenState
import com.example.starbucksfinder.presentation.ui.base.ShopRating
import com.example.starbucksfinder.presentation.ui.navigation.Screen

@Composable
fun ShopItem(starbucksShop: StarbucksShop, navController: NavController, index: Int) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .clickable {
                navController.navigate(Screen.ShopDetailScreen.withArgs(index))
            }
    ) {
        starbucksShop.address?.let { address ->
            Text(
                text = address,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                starbucksShop.isOpen?.let { open ->
                    ShopOpenState(open)
                }
                starbucksShop.rating?.let {
                    ShopRating(it, MaterialTheme.colors.onBackground)
                }
            }
        }
    }
}
