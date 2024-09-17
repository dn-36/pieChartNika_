package org.example.project.presentation.add_transaction.date_feature.viewmodel

sealed class DateIntents {
    object Next:DateIntents()
    object Back:DateIntents()
    object OpenMonth:DateIntents()
    object OpenDay:DateIntents()
    object OpenYear:DateIntents()
    data class ChoosingDay(val day:String):DateIntents()
    data class ChoosingMonth(val month:String):DateIntents()
    data class ChoosingYear(val year:String):DateIntents()
}