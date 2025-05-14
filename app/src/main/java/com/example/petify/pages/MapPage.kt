package com.example.petify.pages

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.petify.ui.theme.PetifyTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun MapPage() {
    MyGoogleMaps()


    /*  Column(modifier = Modifier.fillMaxSize().background(Color.LightGray),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally) {

          Text(text = "Map", fontSize = 30.sp,
              fontFamily = poppins,
              fontWeight = FontWeight.Bold
          )

      }*/

}


@SuppressLint("MissingPermission") // Suprimimos advertencias porque verificamos permisos
@Composable
fun MyGoogleMaps() {
    val context = LocalContext.current

    // Cliente de ubicación
    val fusedLocationClient: FusedLocationProviderClient =
        remember { LocationServices.getFusedLocationProviderClient(context) }

    // Estado para la ubicación actual
    var currentLocation by remember { mutableStateOf<LatLng?>(null) }

    // Estado de la cámara del mapa
    val cameraPositionState = rememberCameraPositionState()

    // Estado para permisos
    var hasLocationPermission by remember { mutableStateOf(false) }

    // Launcher para solicitar permisos
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasLocationPermission = isGranted
        if (isGranted) {
            getCurrentLocation(fusedLocationClient) { location ->
                currentLocation = location
                cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 15f)
            }
        }
    }

    // Verificar permisos al iniciar
    LaunchedEffect(Unit) {
        hasLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (hasLocationPermission) {
            getCurrentLocation(fusedLocationClient) { location ->
                currentLocation = location
                cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 15f)
            }
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    //Mi mapa
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        //contentPadding = PaddingValues(bottom = 100.dp, top = 580.dp, end = 5.dp),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(isMyLocationEnabled = hasLocationPermission),
        uiSettings = MapUiSettings(
            myLocationButtonEnabled = true,
            zoomControlsEnabled = true
            //compassEnabled = true, // Activa la brújula
            //zoomControlsEnabled = true, // Muestra los botones de zoom
            //zoomGesturesEnabled = true
        )
    ) {
        currentLocation?.let { location ->
            Marker(
                state = MarkerState(position = location),
                title = "Tu ubicación",
                snippet = "Aquí estás ahora"
            )
        }
    }
}

// Función para obtener la ubicación actual
@SuppressLint("MissingPermission") // Se llama solo cuando hay permisos
fun getCurrentLocation(
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (LatLng) -> Unit
) {
    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
        location?.let {
            onLocationReceived(LatLng(it.latitude, it.longitude))
        }
    }
}


/*@Composable
fun MyGoogleMaps() {


    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f) }

    // Estado para verificar si tenemos permiso de ubicación
    var hasLocationPermission by remember {
        mutableStateOf(false)
    }

    // Verificar permisos en tiempo de ejecución
    val context = androidx.compose.ui.platform.LocalContext.current
    LaunchedEffect(Unit) {
        hasLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }



    GoogleMap(
        modifier = Modifier.fillMaxSize(),
//        cameraPositionState = cameraPositionState,
        properties = MapProperties(isMyLocationEnabled = hasLocationPermission)

    )*//* {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }*//*

}*/


@Preview(showBackground = true)
@Composable
fun PreviewSc() {
    PetifyTheme {
        MapPage()

    }
}