package com.example.petify.navigation


sealed class AppScreens(val route: String) {

    object SplashScreen : AppScreens ("splash_screen")
    object MainScreen : AppScreens ("main_screen")
    object Login : AppScreens("login")
    object Homepage: AppScreens("home")
    object SingUp : AppScreens("sing_up")


}