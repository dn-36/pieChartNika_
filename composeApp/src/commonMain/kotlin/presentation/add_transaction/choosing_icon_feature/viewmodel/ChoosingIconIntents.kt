package org.example.project.presentation.add_transaction.choosing_icon_feature.viewmodel

import org.jetbrains.compose.resources.DrawableResource

sealed class ChoosingIconIntents {
    data class ChoosingIcon(val index:Int,val image:DrawableResource):ChoosingIconIntents()
    object Back:ChoosingIconIntents()
    object Next:ChoosingIconIntents()
}