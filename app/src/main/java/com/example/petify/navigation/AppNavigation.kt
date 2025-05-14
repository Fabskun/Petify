package com.example.petify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petify.Homepage
import com.example.petify.Login
import com.example.petify.MainScreen
import com.example.petify.SingUp
import com.example.petify.SplashScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen(navController)
        }
        composable(AppScreens.Login.route){
            Login(navController)
        }

        composable(AppScreens.Homepage.route) {
            Homepage()
        }

        composable(AppScreens.SingUp.route) {
            SingUp(navController)
        }


    }
}