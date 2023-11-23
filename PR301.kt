package com.roman.pr301

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roman.pr301.ui.theme.PR301Theme
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función 'comparar()' para establecer el contenido de la actividad
            comparar()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun comparar() {
    // Variables para almacenar datos de entrada y resultados
    var litrosperjudicado by remember { mutableStateOf("") }
    var diametrodelvaso by remember { mutableStateOf("") }
    var alturadelvaso by remember { mutableStateOf("") }
    var vasostotales by remember { mutableStateOf("") }
    var vaso by remember { mutableStateOf(0f) }
    var totalIngerido by remember { mutableStateOf(0f) }
    var estado by remember { mutableStateOf("") }

    // Columna que contiene los campos de entrada y el botón
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        // Campo de entrada para la cantidad máxima permitida para beber
        TextField(
            value = litrosperjudicado,
            onValueChange = {
                litrosperjudicado = it
            },
            label = { Text("Cantidad maxima para tomar en ml") },
            singleLine = true,
            enabled = true,
        )

        // Campo de entrada para el diámetro del vaso en centímetros
        TextField(
            value = diametrodelvaso,
            onValueChange = {
                diametrodelvaso = it
            },
            label = { Text("Introduce el diametro del vaso en cm") },
            singleLine = true,
            enabled = true,
        )

        // Campo de entrada para la altura del vaso
        TextField(
            value = alturadelvaso,
            onValueChange = {
                alturadelvaso = it
            },
            label = { Text("Introduce la altura del vaso") },
            singleLine = true,
            enabled = true,
        )

        // Campo de entrada para la cantidad total de vasos tomados
        TextField(
            value = vasostotales,
            onValueChange = {
                vasostotales = it
            },
            label = { Text("Introduce cuantos vasos has tomado") },
            singleLine = true,
            enabled = true,
        )

        // Botón que realiza el cálculo cuando se hace clic
        Button(
            onClick = {
                // Calcula el volumen de un vaso y la cantidad total ingerida
                vaso = (PI * (diametrodelvaso.toFloat() / 2).pow(2) * alturadelvaso.toFloat()).toFloat()
                totalIngerido = vasostotales.toFloat() * vaso

                // Evalúa el resultado y establece el estado
                if (totalIngerido > litrosperjudicado.toFloat()) {
                    estado = "Te has pasado"
                } else if (totalIngerido < litrosperjudicado.toFloat()) {
                    estado = "Aun puedes beber, te faltan ${litrosperjudicado.toFloat() - totalIngerido} ml"
                }
            },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("Enviar")
        }

        // Muestra el volumen de un vaso y el estado actual
        Text("Un vaso es de ${String.format("%.2f", vaso)} ml")
        Text(estado)
    }
}
