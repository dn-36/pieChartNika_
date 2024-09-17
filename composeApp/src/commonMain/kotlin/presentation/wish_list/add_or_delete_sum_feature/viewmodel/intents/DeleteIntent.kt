package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteViewModel

object DeleteIntent {
    fun execute(){
        AddOrDeleteViewModel.addOrDeleteState = AddOrDeleteViewModel.addOrDeleteState.copy(
            alphaDelete = mutableStateOf(1f),
            alphaAdd = mutableStateOf(0f),
        )
    }
}