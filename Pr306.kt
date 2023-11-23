package com.roman.pr306

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roman.pr306.ui.theme.PR306Theme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PR306Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    fechas()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fechas() {
    val Fechaactual by remember { mutableStateOf(LocalDate.now()) }
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var bisiesto by remember{ mutableStateOf("") }
    var resultado by remember{ mutableStateOf(0) }
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        TextField(
            value = dia,
            onValueChange = {
                dia = it
            },
            label = { Text("Inserta el dia") },
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
        )
        TextField(
            value = mes,
            onValueChange = {
                mes = it
            },
            label = { Text("Inserta el mes") },
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
        )
        TextField(
            value = year,
            onValueChange = {
                year = it
            },
            label = { Text("Inserta el año") },
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
        )

        OutlinedButton(
            onClick = {
                val fechaIngresada = LocalDate.of(year.toInt(), mes.toInt(), dia.toInt())
                    resultado =fechaIngresada.lengthOfMonth() - fechaIngresada.dayOfMonth
                    if (fechaIngresada.isLeapYear){
                        bisiesto="Es bisiesto"
                    }else{
                        bisiesto="No es bisiesto"
                    }
                     },
                ) {
                    Text("INFORMAR")
                }
        Text(bisiesto)
        Text("Dias restantes en el mes: $resultado")
    }
}
