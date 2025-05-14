package com.example.petify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petify.pages.Home
import com.example.petify.pages.MapPage
import com.example.petify.pages.Setting
import com.example.petify.ui.theme.PetifyTheme

@Composable
fun Homepage() {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("map", Icons.Default.LocationOn),
        NavItem("settings", Icons.Default.Settings)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {

            NavigationBar {

                navItemList.forEachIndexed{ index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }

            }

        }) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            ContentScreen(selectedIndex)
        }

        //ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(selectedIndex: Int) {
       when(selectedIndex){
           0-> Home()
           1-> MapPage()
           2-> Setting()
       }

}


@Preview(showBackground = true)
@Composable
fun PreviewScree() {
    PetifyTheme {
        Homepage()

    }
}