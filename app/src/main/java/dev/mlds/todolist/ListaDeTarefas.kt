package dev.mlds.todolist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mlds.todolist.ui.theme.ToDoListTheme

@Composable
fun ListarTarefas(modifier: Modifier = Modifier) {
    val tarefas = criarTarefas()
    LazyColumn(modifier = modifier) {
        items(tarefas) {
            Tarefa(it)
        }
    }
}

@Composable
fun Tarefa(tarefa: TarefaModel) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "07:00 AM", fontSize = 12.sp, color = Color.Gray)
            Divider(Modifier.padding(start = 8.dp), color = Color.Gray, thickness = 1.dp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Descricao(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .align(Alignment.End)
                .background(
                    color = tarefa.corDeFundo, shape = MaterialTheme.shapes.small
                ), tarefa = tarefa
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun Descricao(modifier: Modifier = Modifier, tarefa: TarefaModel) {
    val gests = listOf(Color(0xFF15BECA), Color(0xFFFFB332), Color(0xFF2B3D5A))
    Box(modifier.padding(8.dp)) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = tarefa.titulo, fontSize = 12.sp, color = tarefa.corDoTexto
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow {
                    items(gests) {
                        Gests(it)
                    }
                }
                Buttons(backgroundColor = Color.Green)
            }
        }
    }
}

@Composable
fun Gests(color: Color) {
    Box(
        Modifier
            .background(
                color = color, shape = CircleShape
            )
            .size(20.dp)
    )
}

@Composable
fun Buttons(backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.small
            )
            .size(20.dp)
            .clickable {
                Log.d(">>>", "Click")
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "button"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DescricaoPreview() {
    ToDoListTheme {
        val tarefas = criarTarefas()
        Descricao(tarefa = tarefas[1])
    }
}