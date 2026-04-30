package org.example.jismd

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.example.jismd.presentation.UsuarioViewModel

@Composable
fun ActualizarScreen(
    id: Int,
    nombresActual: String,
    apellidosActual: String,
    onVolver: () -> Unit
) {

    val viewModel = remember { UsuarioViewModel() }
    val scope = rememberCoroutineScope()

    var nombres by remember { mutableStateOf(nombresActual) }
    var apellidos by remember { mutableStateOf(apellidosActual) }

    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Actualizar Usuario", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(12.dp))

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

        Button(onClick = {
            scope.launch {
                try {
                    mensaje = viewModel.actualizar(id, nombres, apellidos)
                    onVolver()
                } catch (e: Exception) {
                    mensaje = "Error: ${e.message}"
                }
            }
        }) {
            Text("Guardar")
        }

        Spacer(Modifier.height(8.dp))

        Text(mensaje)

        Spacer(Modifier.height(8.dp))

        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}