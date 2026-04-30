package org.example.jismd

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource
import apipropia.composeapp.generated.resources.Res
import apipropia.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.example.jismd.presentation.UsuarioViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

import org.example.jismd.model.Usuario

@Composable
fun App() {

    val viewModel = remember { UsuarioViewModel() }
    val scope = rememberCoroutineScope()

    // FORMULARIO CREATE
    var documento by remember { mutableStateOf("") }
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }

    // LISTA
    var usuarios by remember { mutableStateOf(listOf<Usuario>()) }

    // NAVEGACIÓN SIMPLE
    var pantalla by remember { mutableStateOf("lista") }
    var usuarioEditar by remember { mutableStateOf<Usuario?>(null) }

    var mensaje by remember { mutableStateOf("") }

    // =========================
    // PANTALLA ACTUALIZAR
    // =========================
    if (pantalla == "editar" && usuarioEditar != null) {
        ActualizarScreen(
            id = usuarioEditar!!.idUsu!!.toInt(),
            nombresActual = usuarioEditar!!.nombres,
            apellidosActual = usuarioEditar!!.apellidos,
            onVolver = {
                pantalla = "lista"
                usuarioEditar = null
            }
        )
        return
    }

    // =========================
    // PANTALLA LISTA
    // =========================
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("CRUD Usuarios", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(12.dp))

        // FORMULARIO CREAR
        OutlinedTextField(
            value = documento,
            onValueChange = { documento = it },
            label = { Text("Documento") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nombres,
            onValueChange = { nombres = it },
            label = { Text("Nombres") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(10.dp))

        // BOTONES CREAR / LISTAR
        Row {

            Button(onClick = {
                scope.launch {
                    try {
                        viewModel.crear(documento, nombres, apellidos)

                        mensaje = "Usuario creado"

                        documento = ""
                        nombres = ""
                        apellidos = ""

                        usuarios = viewModel.listar()

                    } catch (e: Exception) {
                        mensaje = "Error: ${e.message}"
                    }
                }
            }) {
                Text("Crear")
            }

            Spacer(Modifier.width(8.dp))

            Button(onClick = {
                scope.launch {
                    usuarios = viewModel.listar()
                }
            }) {
                Text("Listar")
            }
        }

        Spacer(Modifier.height(10.dp))

        Text(mensaje)

        Spacer(Modifier.height(10.dp))

        // LISTA
        LazyColumn {

            items(usuarios) { usuario ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {

                        Text("ID: ${usuario.idUsu}")
                        Text("Documento: ${usuario.documento}")
                        Text("Nombres: ${usuario.nombres}")
                        Text("Apellidos: ${usuario.apellidos}")

                        Spacer(Modifier.height(6.dp))

                        Row {

                            // ELIMINAR
                            Button(onClick = {
                                scope.launch {
                                    try {
                                        viewModel.eliminar(usuario.idUsu!!.toInt())
                                        usuarios = viewModel.listar()
                                    } catch (e: Exception) {
                                        mensaje = "Error: ${e.message}"
                                    }
                                }
                            }) {
                                Text("Eliminar")
                            }

                            Spacer(Modifier.width(8.dp))

                            // EDITAR
                            Button(onClick = {
                                usuarioEditar = usuario
                                pantalla = "editar"
                            }) {
                                Text("Editar")
                            }
                        }
                    }
                }
            }
        }
    }
}