package com.roman.pr304

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roman.pr304.ui.theme.PR304Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PR304Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    rndNumber()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rndNumber() {
    var numeroinsertado by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var rnd = remember { mutableStateOf((1..10).random()) }
    Text("Numero es: ${rnd.value}")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text("Intenta adivinar el número entre 1 y 10")
        TextField(
            value = numeroinsertado,
            onValueChange = {
                numeroinsertado = it
            },
            label = { Text("Inserta tu número") },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    val guessed = numeroinsertado.toInt()
                        if (guessed == rnd.value) {
                            resultado = "¡Adivinaste! El número era $guessed."
                            rnd.value = (1..10).random()
                        } else if (guessed==0){
                            System.exit(0)
                        } else{
                            resultado = "Intenta de nuevo. El número no es $guessed."
                            rnd.value = (1..10).random()
                    }
                    numeroinsertado=""
                }
            )
        )
        Text(resultado)

  }
}


