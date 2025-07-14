package com.PDM.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.PDM.weatherapp.ui.theme.WeatherAppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Bem-vindo/a!",
            fontSize = 24.sp
        )
        Spacer(modifier = modifier.size(24.dp))
        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail") },
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(fraction = 0.9f)
        )
        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(fraction = 0.9f)
        )
        Spacer(modifier = modifier.size(24.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    Firebase.auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(activity!!) { task ->
                            if (task.isSuccessful) {
                                activity.startActivity(
                                    Intent(activity, MainActivity::class.java).setFlags(
                                        FLAG_ACTIVITY_SINGLE_TOP
                                    )
                                )
                                Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(activity, "Login FALHOU!", Toast.LENGTH_LONG).show()
                            }
                        }
                },
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            ) {
                Text("Login")
            }
            Button(
                onClick = { email = ""; password = "" },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            ) {
                Text("Limpar")
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    activity?.startActivity(
                        Intent(activity, RegisterActivity::class.java).setFlags(
                            FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            ) {
                Text("Registre-se")
            }
        }
    }
}