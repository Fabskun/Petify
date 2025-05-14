package com.example.petify

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petify.FirebaseAuth.AuthenticationManager
import com.example.petify.ui.theme.DarkGreenP
import com.example.petify.ui.theme.GrayLightP
import com.example.petify.ui.theme.GrayP
import com.example.petify.ui.theme.PetifyTheme
import com.example.petify.ui.theme.WhiteBackgroundP
import com.example.petify.ui.theme.poppins
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun ToggleButton(
    navController: NavController,
    isOn: Boolean = true,
    onSwitch: (Boolean) -> Unit,
) {

    //
    var oncolor by remember {
        mutableStateOf(DarkGreenP)
    }

    var offcolor by remember {
        mutableStateOf(Color.Transparent)
    }

    if (!isOn) {
        oncolor = DarkGreenP
        offcolor = Color.Transparent
    } else {
        oncolor = Color.Transparent
        offcolor = DarkGreenP
    }


    Surface(
        modifier = Modifier
            .width(308.dp)
            .height(58.dp),
        color = GrayP,
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
                    .clickable {
                        onSwitch(false)
                    },
                color = oncolor,
                shape = RoundedCornerShape(40.dp)
            ) {

                // the Surceface left
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Log in",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        //poppins
                        fontFamily = poppins,
                        color = Color.White
                    )
                }
            }
            // the Surface Right
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onSwitch(true)
                               navController.navigate("sing_up")
                               },
                color = offcolor,
                shape = RoundedCornerShape(40.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        "Sing up",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        //poppins
                        fontFamily = poppins,
                        color = Color.White
                    )
                }
            }


        }
    }
}


@Composable
fun OutLineTextFieldSample(textState: MutableState<TextFieldValue>, keyboardOptions: KeyboardOptions ) {
    //var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textState.value,

        //label = { Text("Hola") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            focusedBorderColor = DarkGreenP, // Color cuando está enfocado
            unfocusedBorderColor = GrayLightP // Color cuando no está enfocado
        ),
        onValueChange = {
            textState.value = it
        },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        maxLines = 1,
    )
}

//Here this logic code for button

//fun ButtonLogin(onClick: () -> Unit) {
//
//
//}


@Composable
fun Login(navController: NavController) {

    val focusManager = LocalFocusManager.current
    val emailState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    val authenticationManager = remember {
        AuthenticationManager()
    }

    val coroutineScope = rememberCoroutineScope()


    var isOn by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundP)
    ) {

        Image(
            painter = painterResource(id = R.drawable.imgheader),
            contentDescription = "Header image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(width = 440.dp, height = 405.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                painter = painterResource(id = R.drawable.imgform),
                contentDescription = "Imagen oculta",
                modifier = Modifier
                    //.size(200.dp)
                    .alpha(0f) // Hace que la imagen sea completamente transparente pero sigue ocupando espacio
            )

            Box(
                modifier = Modifier
                    .size(width = 500.dp, height = 440.dp)
                    .clip(RoundedCornerShape(40.dp))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly

                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            ToggleButton(navController = navController, isOn = isOn, onSwitch = {
                                isOn = it
                            })

                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()

                            .height(36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            "Welcome to Petify",
                            fontSize = 24.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(92.dp)
                            .padding(25.dp, 0.dp, 0.dp, 20.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp)
                        ) {

                            Text("Email", fontSize = 14.sp, color = GrayLightP)
                        }

                        Column {
                            OutLineTextFieldSample(textState = emailState, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(92.dp)
                            .padding(25.dp, 0.dp, 0.dp, 20.dp)
                    ) {


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp)
                        ) {

                            Text("Password", fontSize = 14.sp, color = GrayLightP)
                        }

                        Column {
                            OutLineTextFieldSample(textState = passwordState, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                              )
                        }

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Column {

                            Button(
                                onClick = {
                                    val email = emailState.value.text
                                    val password = passwordState.value.text

                                    if (email.isNotEmpty() && password.isNotEmpty()) {

                                        authenticationManager.loginWithEmail(
                                            email,
                                            password
                                        )
                                            .onEach { response ->
                                                if (response is AuthResponse.Success) {
                                                    navController.navigate("home")
                                                } else if (response is AuthResponse.Error) {
                                                    Toast.makeText(
                                                        context,
                                                        response.message,
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            }
                                            .launchIn(coroutineScope)

                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Verifica tus Campos",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }


                                },
                                modifier = Modifier.size(width = 280.dp, height = 58.dp),
                                colors = ButtonDefaults.buttonColors(DarkGreenP),
                            ) {
                                Text(
                                    "Log in", fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    //poppins
                                    fontFamily = poppins,
                                    color = Color.White
                                )
                            }

                        }

                        Column {
                            Text(
                                "Forgot Password ?",
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }

                    }


                }


            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    PetifyTheme {
        val navController = rememberNavController()
        Login(navController)

    }
}