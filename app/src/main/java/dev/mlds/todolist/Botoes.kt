package dev.mlds.todolist

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Log.d(">>>", "Click")
            }
            .background(
                color = Color(0xFF0096FF),
                shape = MaterialTheme.shapes.small
            )
            .padding(10.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Color.White)
    }
}