package dev.mlds.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Agenda") }
                            )
                        },
                        content = {
                            Lista(it)
                        },
                        bottomBar = {
                            BottomAppBar {
                                // Conteúdo da barra inferior
                                BottomActions()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun BottomActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // Adicione suas ações da parte inferior aqui
        Text("Ação 1")
        Spacer(modifier = Modifier.width(16.dp))
        Text("Ação 2")
    }
}

@Composable
fun Lista(paddingValues: PaddingValues = PaddingValues()) {
    Box(Modifier.padding(16.dp)) {
        Column(modifier = Modifier.padding(paddingValues)) {
            CalendarView()
            ListarTarefas(modifier = Modifier.weight(1f))
            PrimaryButton(text = "Criar novo evento")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListPreview() {
    ToDoListTheme {
        Lista()
    }
}