package com.example.petify.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petify.R
import com.example.petify.ui.theme.PetifyTheme
import com.example.petify.ui.theme.WhiteBackgroundP
import com.example.petify.ui.theme.poppins

val myrowmodifier = Modifier
    .fillMaxWidth()
    .height(70.dp)
    .padding(10.dp)

val commonTextStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppins,
    fontWeight = FontWeight.Bold,
    color = Color.Black
)


@Composable
fun Setting() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundP),
        verticalArrangement = Arrangement.SpaceBetween

    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
            //.background(Color.Gray)

        ) {

            Spacer(modifier = Modifier.size(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {

                Column(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                ) { }

                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Profile",
                        fontSize = 18.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Column(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.trespuntos),
                        contentDescription = null
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.logopetify),
                    contentDescription = "user image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    "Anna Simpson", fontSize = 14.sp, fontFamily = poppins,
                    fontWeight = FontWeight.Bold, color = Color.Black
                )


            }


        }
        Box(
            modifier = Modifier
                .size(490.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                ) // Aplica el recorte primero
                .background(Color.White) // Luego aplica el fondo
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                //este era codigo normal
                /*                Row(
                                    modifier = myrowmodifier,
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.iconuser),
                                        contentDescription = null
                                    )

                                    Text(
                                        "Personal info",
                                        style = commonTextStyle
                                    )

                                }*/

                //Esta parte se refecatorizo el codigo para simplicar con una funcion composable llamada > MycomponetRow

                MycomponetRow(R.drawable.iconuser, "Personal info")

                MycomponetRow(R.drawable.iconsettings, "Settings")

                MycomponetRow(R.drawable.iconhelp, "Help")

                MycomponetRow(R.drawable.iconlogout, "Log out")

            }
        }


    }


    /*   Column(modifier = Modifier.fillMaxSize().background(Color.LightGray),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {

           Text(text = "Setting", fontSize = 30.sp,
               fontFamily = poppins,
               fontWeight = FontWeight.Bold
           )

       }*/

}

@Composable
fun MycomponetRow(id: Int, text: String) {

    Row(
        modifier = myrowmodifier, verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Image(
            painter = painterResource(id),
            contentDescription = null
        )

        Text(
            text,
            style = commonTextStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScr() {
    PetifyTheme {
        Setting()

    }
}