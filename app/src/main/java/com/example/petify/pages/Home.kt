package com.example.petify.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.petify.ui.theme.GrayLightP
import com.example.petify.ui.theme.PetifyTheme
import com.example.petify.ui.theme.WhiteBackgroundP
import com.example.petify.ui.theme.poppins


val textsetting = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppins,
    fontWeight = FontWeight.Bold,
    color = Color.Black
)


@Composable
fun Home() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(initial = 1))
            .background(WhiteBackgroundP),
        //verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            //.padding(top = 50.dp)
            //.background(Color.Gray),
            verticalArrangement = Arrangement.Center
        ) {

            //There is fix to code
            Row(
                modifier = Modifier
                    .width(350.dp)
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)


            ) {
                Image(
                    painter = painterResource(R.drawable.logopetify),
                    contentDescription = "user image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )

                Text(
                    text = "Take your fight for\n" +
                            "the future, Anna!", style = textsetting
                )

            }


        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
            //.background(Color.LightGray)
        ) {

            Text(
                "Waste Categories",

                style = textsetting, modifier = Modifier.padding(20.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.horizontalScroll(ScrollState(initial = 1))
                    .height(160.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                //Here is a Lazy Jetpack compose
                Surface(
                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp),
                    color = Color.White,
                    shape = RoundedCornerShape(40.dp)
                ) { }
                Surface(
                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp),
                    color = Color.White,
                    shape = RoundedCornerShape(40.dp)
                ) { }
                Surface(
                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp),
                    color = Color.White,
                    shape = RoundedCornerShape(40.dp)
                ) { }

            }

        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                // .background(Color.Red)
                .padding(20.dp)
        ) {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                //.background(Color.Red),
                , verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Text(
                    "Plastic Code",
                    fontSize = 20.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold
                )
                //modifier = Modifier.padding(20.dp))

                ToggleButton3() { }
            }

            val mymodfi = Modifier.fillMaxWidth().height(152.dp).background(Color.Red)

            Column(modifier = mymodfi) {
                
            }

            Surface(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
                color = Color.Red) {

            }


            /*  Surface(
                  modifier = Modifier
                      .fillMaxWidth()
                      .height(160.dp),
                  color = Color.White,
                  shape = RoundedCornerShape(40.dp)
              ) { }*/


        }


    }

    /*   Column(modifier = Modifier.fillMaxSize().background(Color.LightGray),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {

           Text(text = "Home", fontSize = 30.sp,
               fontFamily = poppins,
               fontWeight = FontWeight.Bold
               )

       }*/


}

@Composable
fun ToggleButton3(
    //navController: NavController,
    isOn: Boolean = true,
    onSwitch: (Boolean) -> Unit
) {


    //
    var oncolor by remember {
        mutableStateOf(Color.White)
    }

    var offcolor by remember {
        mutableStateOf(Color.Transparent)
    }

    if (!isOn) {
        oncolor = Color.White
        offcolor = Color.Transparent
    } else {
        oncolor = Color.Transparent
        offcolor = Color.White

    }


    Surface(
        modifier = Modifier
            .width(380.dp)
            .height(60.dp),
        color = GrayLightP,
        shape = RoundedCornerShape(40.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                /* .clickable { navController.navigate("login")
                     onSwitch(true)

                 }*/,

                color = offcolor,
                shape = RoundedCornerShape(40.dp)
            ) {

                // the Surceface left
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Recyclabe",
                        style = textsetting
                    )
                }
            }
            // the Surface Right
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),

                // .clickable { onSwitch(false) },
                color = oncolor,
                shape = RoundedCornerShape(40.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        "No-recycable",
                        style = textsetting
                    )
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScre() {
    PetifyTheme {
        Home()

    }
}