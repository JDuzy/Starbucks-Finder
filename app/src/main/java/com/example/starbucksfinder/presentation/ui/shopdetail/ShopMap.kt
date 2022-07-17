package com.example.starbucksfinder.presentation.ui.shopdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.starbucksfinder.domain.model.Location
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

private const val Zoom = 16f

@Composable
fun ShopMap(location: Location) {

    val uiSettings = remember { MapUiSettings(zoomControlsEnabled = false) }
    val pos = LatLng(location.lat, location.lng)

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = MapProperties(),
        uiSettings = uiSettings,
        cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(
                LatLng(location.lat, location.lng),
                Zoom
            )
        }
    ) {
        Marker(position = pos)
    }
}
