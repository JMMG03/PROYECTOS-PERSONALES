@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.pedidosscaffoll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            contenido()
        }
    }
}
// Hacer algo, con una imagen y dos botones, uno que sume y otro que reste
// en la mitad habrá un número que irá cambiando en funcion de lo anterior
// más abajo hay un texto que dirá la cantidad total de productos que hay
@Preview
@Composable
@ExperimentalMaterial3Api
fun contenido() {
    var precioTotal by remember { mutableStateOf(0.0) }
    // Para la sección de panadería
    var cantidadBarra by remember { mutableStateOf(0) }
    var cantidadCroissant by remember { mutableStateOf(0) }
    var cantidadEmpanada by remember { mutableStateOf(0) }

    // Para la sección de pescadería
    var cantidadPulpo by remember { mutableStateOf(0) }
    var cantidadSalmon by remember { mutableStateOf(0) }
    var cantidadCangrejo by remember { mutableStateOf(0) }

    // Para la sección de carnicería
    var cantidadCortesCarne by remember { mutableStateOf(0) }
    var cantidadPollo by remember { mutableStateOf(0) }
    var cantidadBuey by remember { mutableStateOf(0) }

    // Para la sección de verdulería
    var cantidadBrocoli by remember { mutableStateOf(0) }
    var cantidadTomate by remember { mutableStateOf(0) }
    var cantidadPatata by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Supermercado", textAlign = TextAlign.Center) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.black),
                    titleContentColor = Color.White
                ),
            )
        },
        content = { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                item {
                    Column(
                        modifier = Modifier
                            .background(Color.Yellow)
                    ) {
                        Text(
                            text = "PANADERÍA",
                            textAlign = TextAlign.Center,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )
                        LazyRow(modifier = Modifier.padding(top = 10.dp, start = 25.dp)) {
                            item {
                                ProductoItem(
                                    nombre = "Barra de Pan",
                                    precio = 0.90,
                                    cantidad = cantidadBarra,
                                    onRestar = { cantidadBarra--; precioTotal -= 0.90 },
                                    onSumar = { cantidadBarra++; precioTotal += 0.90 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Croissant",
                                    precio = 1.20,
                                    cantidad = cantidadCroissant,
                                    onRestar = { cantidadCroissant--; precioTotal -= 1.20 },
                                    onSumar = { cantidadCroissant++; precioTotal += 1.20 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Empanada",
                                    precio = 3.00,
                                    cantidad = cantidadEmpanada,
                                    onRestar = { cantidadEmpanada--; precioTotal -= 3.00 },
                                    onSumar = { cantidadEmpanada++; precioTotal += 3.00 }
                                )
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .background(Color.Cyan)
                    ) {
                        Text(
                            text = "PESCADERÍA",
                            textAlign = TextAlign.Center,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )
                        LazyRow(modifier = Modifier.padding(top = 10.dp, start = 25.dp)) {
                            item {
                                ProductoItem(
                                    nombre = "Pulpo",
                                    precio = 2.00,
                                    cantidad = cantidadPulpo,
                                    onRestar = { cantidadPulpo--; precioTotal -= 2.00 },
                                    onSumar = { cantidadPulpo++; precioTotal += 2.00 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Salmón",
                                    precio = 4.30,
                                    cantidad = cantidadSalmon,
                                    onRestar = { cantidadSalmon--; precioTotal -= 4.30 },
                                    onSumar = { cantidadSalmon++; precioTotal += 4.30 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Cangrejo",
                                    precio = 2.00,
                                    cantidad = cantidadCangrejo,
                                    onRestar = { cantidadCangrejo--; precioTotal -= 2.00 },
                                    onSumar = { cantidadCangrejo++; precioTotal += 2.00 }
                                )
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .background(colorResource(id = R.color.rojooo))
                    ) {
                        Text(
                            text = "CARNICERÍA",
                            textAlign = TextAlign.Center,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )
                        LazyRow(modifier = Modifier.padding(top = 10.dp, start = 25.dp)) {
                            item {
                                ProductoItem(
                                    nombre = "Cortes de Carne",
                                    precio = 4.50,
                                    cantidad = cantidadCortesCarne,
                                    onRestar = { cantidadCortesCarne--; precioTotal -= 4.50 },
                                    onSumar = { cantidadCortesCarne++; precioTotal += 4.50 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Pollo",
                                    precio = 5.00,
                                    cantidad = cantidadPollo,
                                    onRestar = { cantidadPollo--; precioTotal -= 5.00 },
                                    onSumar = { cantidadPollo++; precioTotal += 5.00 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Buey",
                                    precio = 12.00,
                                    cantidad = cantidadBuey,
                                    onRestar = { cantidadBuey--; precioTotal -= 12.00 },
                                    onSumar = { cantidadBuey++; precioTotal += 12.00 }
                                )
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .background(Color.Green)
                    ) {
                        Text(
                            text = "VERDULERÍA",
                            textAlign = TextAlign.Center,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )
                        LazyRow(modifier = Modifier.padding(top = 10.dp, start = 25.dp)) {
                            item {
                                ProductoItem(
                                    nombre = "Brócoli",
                                    precio = 0.50,
                                    cantidad = cantidadBrocoli,
                                    onRestar = { cantidadBrocoli--; precioTotal -= 0.50 },
                                    onSumar = { cantidadBrocoli++; precioTotal += 0.50 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Tomate",
                                    precio = 1.05,
                                    cantidad = cantidadTomate,
                                    onRestar = { cantidadTomate--; precioTotal -= 1.05 },
                                    onSumar = { cantidadTomate++; precioTotal += 1.05 }
                                )
                            }
                            item {
                                ProductoItem(
                                    nombre = "Patata",
                                    precio = 3.75,
                                    cantidad = cantidadPatata,
                                    onRestar = { cantidadPatata--; precioTotal -= 3.75 },
                                    onSumar = { cantidadPatata++; precioTotal += 3.75 }
                                )
                            }
                        }
                    }
                }
            }
        }, bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.black),
                contentColor = Color.Black,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 25.dp),
                    textAlign = TextAlign.Center,
                    text = "Total: ${precioTotal.format(2)} €", // Muestra el total formateado con 2 dígitos decimales.
                    color = Color.White
                )
            }
        }
    )
}
@Composable
// Anotación que indica que esta función es una composable de Jetpack Compose.
fun ProductoItem(
    nombre: String,
    precio: Double,
    cantidad: Int,
    onRestar: () -> Unit,
    onSumar: () -> Unit
) {
    // Composable Column que organiza los elementos de manera vertical.
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupa el espacio máximo disponible.
        horizontalAlignment = Alignment.CenterHorizontally // Alinea los elementos horizontalmente al centro.
    ) {
        // Texto que muestra el nombre del producto.
        Text(
            text = nombre,
            textAlign = TextAlign.Center,
        )

        // Imagen del producto, cuyo ID se obtiene mediante la función obtenerIdImagen.
        Image(
            painter = painterResource(id = obtenerIdImagen(nombre)),
            contentDescription = null,
            modifier = Modifier
                .size(width = 50.dp, height = 50.dp)
        )

        // Texto que muestra el precio del producto en euros.
        Text(text = "${precio} €")

        // Row que contiene tres columnas para mostrar botones y la cantidad del producto.
        Row {
            // Columna con un IconButton para restar la cantidad del producto.
            Column {
                IconButton(onClick = onRestar) {
                    Image(
                        painter = painterResource(id = R.drawable.restar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 25.dp, height = 25.dp)
                    )
                }
            }

            // Columna que muestra la cantidad actual del producto.
            Column {
                Text(
                    text = "$cantidad",
                    fontSize = 30.sp
                )
            }

            // Columna con un IconButton para sumar la cantidad del producto.
            Column {
                IconButton(onClick = onSumar) {
                    Image(
                        painter = painterResource(id = R.drawable.sumar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 25.dp, height = 25.dp)
                    )
                }
            }
        }
    }
}

// La anotación '@DrawableRes' indica que la función devuelve un identificador de recurso drawable.
@DrawableRes
// Define una función llamada 'obtenerIdImagen' que asigna un ID de recurso drawable según el nombre proporcionado.
fun obtenerIdImagen(nombre: String): Int {
    // Utiliza una expresión 'when' para comparar el parámetro 'nombre' con diferentes opciones.
    return when (nombre) {
        "Barra de Pan" -> R.drawable.barra
        "Croissant" -> R.drawable.croissant
        "Empanada" -> R.drawable.empanada
        "Pulpo" -> R.drawable.pulpo
        "Salmón" -> R.drawable.salm_n
        "Cangrejo" -> R.drawable.cangrejo
        "Cortes de Carne" -> R.drawable.cortes_de_carne
        "Pollo" -> R.drawable.pollo
        "Buey" -> R.drawable.buey
        "Brócoli" -> R.drawable.br_coli
        "Tomate" -> R.drawable.tomate
        "Patata" -> R.drawable.patata
        // Si no coincide con ninguna de las opciones anteriores, devuelve un recurso predeterminado (launcher_foreground).
        else -> R.drawable.ic_launcher_foreground
    }
}
// La función toma un parámetro 'digits' que representa la cantidad de dígitos decimales deseados.
fun Double.format(digits: Int) = "%.${digits}f".format(this)
