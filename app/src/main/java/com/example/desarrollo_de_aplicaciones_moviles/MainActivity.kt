package com.example.desarrollo_de_aplicaciones_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import com.example.desarrollo_de_aplicaciones_moviles.ui.theme.Desarrollo_de_aplicaciones_movilesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Desarrollo_de_aplicaciones_movilesTheme {
                var nombre by remember { mutableStateOf("") }
                var modal by remember { mutableStateOf(false) }
                var terminos by remember { mutableStateOf(false) }
                fun abrirModal(){ modal = true }
                fun cerrarModal(){ modal = false }
                fun validarNombre(): Boolean{
                    if(nombre == ""){
                        return true
                    } else {
                        return false
                    }
                }
                fun validarTerminos(): Boolean{
                    if(terminos){
                        return true
                    } else {
                        return false
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Ingresa nombre") }
                    )
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Checkbox(
                            checked = terminos,
                            onCheckedChange = { terminos = it }
                        )
                        Text("Acepto los terminos y condiciones")
                    }

                    Button(
                        onClick={abrirModal()},
                        enabled = validarTerminos() && !validarNombre()
                    ) {
                        Text(text="Enviar")
                    }
                }
                if(modal) {
                    AlertDialog(
                        onDismissRequest = { },
                        title = { Text("Confirmación") },
                        text = { Text("Formulario enviado correctamente") },
                        confirmButton = {
                            Button(onClick = {cerrarModal()}) { Text("OK") }
                        }
                    )
                }
            }
        }
    }
}