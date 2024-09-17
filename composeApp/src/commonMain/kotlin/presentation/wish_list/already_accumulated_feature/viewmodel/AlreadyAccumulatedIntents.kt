package org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel

sealed class AlreadyAccumulatedIntents {
    data class Next(val already:String):AlreadyAccumulatedIntents()
    object Back:AlreadyAccumulatedIntents()
}