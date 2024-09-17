package org.example.project.presentation.menu_feature.utils

import kotlinx.datetime.*

fun getTodayDay(): Int {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.dayOfMonth
}

fun getCurrentYear(): Int {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.year
}

fun getCurrentMonth(): String {
    val month = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.month.name
    return month.lowercase().replaceFirstChar { it.uppercase() }
}
fun getDaysOfCurrentWeek(): List<Int> {
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val firstDayOfWeek = today.minus(today.dayOfWeek.ordinal.toLong(), DateTimeUnit.DAY) // Понедельник
    return (0..6).map { offset -> firstDayOfWeek.plus(offset, DateTimeUnit.DAY).dayOfMonth }
}
fun main() {
    println("o" +
            "o" +
            "k")
    println("Дни текущей недели: ${getDaysOfCurrentWeek()}${getCurrentMonth()}${getCurrentYear()}${getTodayDay()}")
    println("o" +
            "o" +
            "k")
}