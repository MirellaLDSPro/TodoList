package dev.mlds.todolist

import androidx.compose.ui.graphics.Color

data class TarefaModel(
    val titulo: String,
    val descricao: String,
    val dataCriacao: String,
    val dataFinal: String,
    val dataExecucao: String,
    val corDeFundo: Color,
    val corDoTexto: Color,
    val convidados: List<Contato>
) {
    data class Contato(
        val nome: String,
        val email: String,
        val telefone: String
    )
}


fun criarTarefas() = listOf(
    TarefaModel(
        titulo = "Startup Website development",
        descricao = "Descrição da tarefa",
        dataCriacao = "",
        dataFinal = "",
        dataExecucao = "",
        corDeFundo = Color(0xFFF1F8FF),
        corDoTexto = Color(0xFF0495FF),
        convidados = listOf()
    ),
    TarefaModel(
        titulo = "Meeting with team",
        descricao = "Descrição da tarefa",
        dataCriacao = "",
        dataFinal = "",
        dataExecucao = "",
        corDeFundo = Color(0xFFF6F2FF),
        corDoTexto = Color(0xFF6C28F5),
        convidados = listOf()
    ),
    TarefaModel(
        titulo = "Discussing Banner Design",
        descricao = "Descrição da tarefa",
        dataCriacao = "",
        dataFinal = "",
        dataExecucao = "",
        corDeFundo = Color(0xFFFFF8DB),
        corDoTexto = Color(0xFFFCD100),
        convidados = listOf()
    )
)
