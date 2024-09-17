package org.example.project.presentation.wish_list.amount_savings_feature.viewmodel

sealed class AmountSavingsIntents {
    object Back:AmountSavingsIntents()
    data class Next(val amount:String):AmountSavingsIntents()
}