package com.example.firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebase.ui.theme.FirebaseTheme
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EnviarMensajeAFirebase("Android")
                }
            }
        }
    }
}

@Composable
fun EnviarMensajeAFirebase(name: String, modifier: Modifier = Modifier) {
    var numero = 0
    Button(onClick = {
        val database = Firebase.database
        val myRef = database.getReference(numero++.toString())

        myRef.setValue("Hello, World!")
    }) {
        Text(text = "Mandar dato a firebase")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseTheme {
        EnviarMensajeAFirebase("Android")
    }
}