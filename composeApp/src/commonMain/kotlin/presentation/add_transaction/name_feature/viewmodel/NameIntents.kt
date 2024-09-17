package org.example.project.presentation.add_transaction.name_feature.viewmodel

sealed class NameIntents {
    object Back:NameIntents()
    data class Next(val name:String):NameIntents()
}