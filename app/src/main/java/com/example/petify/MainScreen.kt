package com.example.petify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petify.ui.theme.DarkGreenP
import com.example.petify.ui.theme.LightGreenP
import com.example.petify.ui.theme.PetifyTheme
import com.example.petify.ui.theme.WhiteBackgroundP
import com.example.petify.ui.theme.poppins


@Composable
fun MainScreen(navController: NavController) {



    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.login_screen),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Mytext("Clean & Modern")
                Mytext("Recycling App")

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
/*
                Row(
                    modifier = Modifier.width(200.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(R.drawable.facebook),
                        contentDescription = "Button Facebook"
                    )

                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(R.drawable.google),
                        contentDescription = "Button Google"
                    )


                }*/

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Button(
                    onClick = {
                        // we need pass this code to change screen
                        navController.navigate("login")
                    },
                    colors = ButtonDefaults.buttonColors(DarkGreenP),
                    modifier = Modifier
                        .width(308.dp)
                        .height(58.dp)
                ) {

                    Text(
                        "Login", fontSize = 18.sp,
                        fontFamily = poppins,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Don't have an account",
                        color = WhiteBackgroundP,
                        fontSize = 12.sp
                    )

                    TextButton(onClick = { navController.navigate("sing_up") }) {
                        Text(
                            "Sing up", color = LightGreenP,
                            fontSize = 12.sp
                        )
                    }


                }


            }

        }


    }


}


@Composable
fun Mytext(text: String) {
    Text(
        text, fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    PetifyTheme {
        val navController = rememberNavController()
        MainScreen(navController)

    }
}