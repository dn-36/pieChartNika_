package org.example.project.presentation.add_transaction.sum_feature.viewmodel

sealed class SumIntents {
    object Back:SumIntents()
    data class Next(val sum:String):SumIntents()
}