@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplCalculadora()
        }
    }
}

@Preview
@Composable
fun AplCalculadora() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("CALCULADORA", "CALCULADORA CIENTÍFICA")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { indice, tituloTab -> //al iterar se asigna automaticamente
                Tab(
                    text = { Text(tituloTab) }, // Mostramos el texto
                    selected = (tabIndex == indice),
                    onClick = { tabIndex = indice }
                )
            }
        }
    }
    when (tabIndex) {
        0 -> Calculadora()
        1 -> CalculadoraCientifica()
    }
}

@ExperimentalMaterial3Api
@Composable
fun Calculadora() {
    // Creo una variable mutable
    var textoInput by remember { mutableStateOf("") }

    // Creo distintos valores de los botones asignadolos en una lista
    val botonValor = listOf(
        listOf("C", "", "", "<-"),
        listOf("1", "2", "3", "+"),
        listOf("4", "5", "6", "-"),
        listOf("7", "8", "9", "x"),
        listOf(".", "0", "=", "/")
    )

    Column(
        modifier = Modifier
            .padding(top = 60.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = textoInput,
            onValueChange = { textoInput = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .focusProperties { canFocus = false }
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        botonValor.forEach { rowValues ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                rowValues.forEach { botonV ->
                    Button(
                        onClick = {
                            if (botonV == "C") { // Un valor que limpia la info
                                textoInput = ""
                            } else if (botonV == "<-") { // Elimino el valor
                                if (textoInput.isNotEmpty()) {
                                    textoInput = textoInput.dropLast(1)
                                }
                            } else if (botonV == "=") { // Utilizo el igual para obtener el resultado de la operacion
                                val result = operacion(textoInput)
                                textoInput = result.toString()
                            } else {
                                textoInput += botonV
                            }
                        }, modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = botonV,
                            style = androidx.compose.ui.text.TextStyle(
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CalculadoraCientifica() {
    var textoInput by remember { mutableStateOf("") }

    val botonesValor = listOf(
        listOf("C", "", "", "<-"),
        listOf("^", "sin", "cos", "tan"),
        listOf("", " 1 ", "2", "3", "+"),
        listOf("", "4", "5", "6", "-"),
        listOf("", "7", "8", "9", "x"),
        listOf("", ".", "0", "=", "/")
    )

    Column(
        modifier = Modifier
            .padding(top = 60.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = textoInput,
            onValueChange = { textoInput = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .focusProperties { canFocus = false }
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        botonesValor.forEach { rowValues ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                rowValues.forEach { botonValor ->
                    Button(
                        onClick = {
                            when (botonValor) {
                                "C" -> textoInput = ""
                                "<-" -> if (textoInput.isNotEmpty()) textoInput =
                                    textoInput.dropLast(1)

                                "=" -> {
                                    val result = operacion(textoInput)
                                    textoInput = result.toString()
                                }

                                "sin" -> {
                                    // Calcular el seno de un número (en radianes)
                                    val num = textoInput.toDouble()
                                    val result = Math.sin(num)
                                    textoInput = result.toString()
                                }

                                "cos" -> {
                                    // Calcular el coseno de un número (en radianes)
                                    val num = textoInput.toDouble()
                                    val result = Math.cos(num)
                                    textoInput = result.toString()
                                }

                                "tan" -> {
                                    // Calcular la tangente de un número (en radianes)
                                    val num = textoInput.toDouble()
                                    val result = Math.tan(num)
                                    textoInput = result.toString()
                                }

                                "^" -> textoInput += "^" // Agregar el operador de exponente
                                else -> textoInput += botonValor
                            }
                        }, modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = botonValor,
                            style = androidx.compose.ui.text.TextStyle(
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}// Creo una funcion para distintas operaciones que pasa como parametros los valores de los botones de operaciones
fun operacion(expresion: String): Double {
    // Define un conjunto de operadores válidos
    val operadores = setOf("+", "-", "x", "/", "^")
    // Busca el operador en la expresión
    for (operador in operadores) {
        if (expresion.contains(operador)) {
            // Divide la expresión en dos partes usando el operador encontrado
            val partes = expresion.split(operador)
            // Verifica que haya dos partes después de la división
            if (partes.size == 2) {
                // Convierte las partes a números de punto flotante
                val num1 = partes[0].toDouble()
                val num2 = partes[1].toDouble()

                // Realiza la operación correspondiente según el operador
                return when (operador) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "x" -> num1 * num2
                    "/" -> num1 / num2
                    "^" -> Math.pow(num1, num2)
                    else -> 0.0  // En caso de un operador no reconocido, devuelve 0.0
                }
            }
        }
    }
    // Si no se encontró ningún operador, devolver el número tal cual
    return expresion.toDouble()
}

