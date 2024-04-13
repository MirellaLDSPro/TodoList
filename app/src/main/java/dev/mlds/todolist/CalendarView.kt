package dev.mlds.todolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mlds.todolist.ui.theme.ToDoListTheme
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@Composable
fun CalendarView() {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {

    val dayOfMonth = getDaysOfMonth()
    val month = dayOfMonth[0].month.getDisplayName(TextStyle.FULL, Locale.getDefault())
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Sharp.KeyboardArrowLeft, contentDescription = "left", tint = Color.LightGray)
            Text(
                text = month,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight(600))
            )
            Icon(Icons.Sharp.KeyboardArrowRight, contentDescription = "rigth", tint = Color.LightGray)
        }
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(dayOfMonth) { day ->
                DayItem(day = day)
            }
        }
    }
//    }
}

@Composable
fun DayItem(day: LocalDate) {
    val isToday = day == LocalDate.now()
    val dayOfWeek = day.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val dayOfMonth = day.dayOfMonth

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Item("$dayOfMonth", dayOfWeek, isToday)
    }
}

@Composable
fun Item(dayOfMonth: String, dayOfWeek: String, isToday: Boolean) {
    val backgroundColor = if (isToday) Color(0xFF0495FF) else Color.White
    val textColor = if (isToday) Color.White else Color.Black
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.medium
            )
            .padding(6.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = dayOfMonth,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                color = textColor
            )
            Text(
                text = dayOfWeek,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isToday) Color.White else Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
}

fun getDaysOfMonth(): List<LocalDate> {
    val daysOfMonth = mutableListOf<LocalDate>()
    val startDate = LocalDate.now().withDayOfMonth(1) // Primeiro dia do mês atual
    val endDate = startDate.plusMonths(1).minusDays(1) // Último dia do mês atual

    var currentDate = startDate
    while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)) {
        daysOfMonth.add(currentDate)
        currentDate = currentDate.plusDays(1)
    }

    return daysOfMonth
}

@Preview(showBackground = true)
@Composable
fun CalendarViewPreview() {
    ToDoListTheme {
        CalendarView()
    }
}