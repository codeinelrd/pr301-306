package com.roman.pr302

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roman.pr302.ui.theme.PR302Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura la interfaz de usuario con la función setContent
        setContent {
            // Llama a la función RadioButtonSample para mostrar los botones de radio
            RadioButtonSample()
        }
    }
}


// La función RadioButtonSample permanece sin cambios
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonSample() {
    // Lista de opciones para los botones de radio
    val radioOptions = listOf("Ver saldo", "Ingresar dinero", "Sacar dinero", "Salir")
    var saldo by remember { mutableStateOf(12345.78f) }

    // Estado mutable para mantener la opción seleccionada
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    // Columna que contendrá los botones de radio
    Column {
        // Itera sobre las opciones y crea un botón de radio para cada una
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    // Utiliza el modificador "selectable" para hacer que cada fila sea seleccionable
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            // Cuando se hace clic en una fila, actualiza la opción seleccionada
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                // Crea un botón de radio para cada opción
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                // Muestra el texto de la opción al lado del botón de radio
                Text(text = text)
            }
        }

        when (selectedOption) {
            "Ver saldo" -> Text("Tu saldo es: $saldo")
            "Ingresar dinero" -> {
                var ingresardinero by remember { mutableStateOf("") }
                TextField(
                    value = ingresardinero,
                    onValueChange = {
                        ingresardinero = it
                    },
                    label = { Text("Ingresa el dinero") },
                    singleLine = true,
                    enabled = true,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            val ingreso: Float = ingresardinero.toFloat()
                            saldo += ingreso
                            ingresardinero =""
                        }
                    )
                )
            }
            "Sacar dinero" -> {
                var sacardinero by remember { mutableStateOf("") }
                TextField(
                    value = sacardinero,
                    onValueChange = {
                        sacardinero = it
                    },
                    label = { Text("Sacar dinnero") },
                    singleLine = true,
                    enabled = true,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            val retirada: Float = sacardinero.toFloat()
                            saldo -= retirada
                            sacardinero=""
                        }
                    )
                )
            }
            "Salir" -> {
                System.exit(0)
                }
        }

    }
}



