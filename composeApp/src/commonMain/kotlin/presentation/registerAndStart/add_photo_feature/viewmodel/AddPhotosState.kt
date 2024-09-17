package org.example.project.presentation.registerAndStart.add_photo_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.jetbrains.compose.resources.DrawableResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.no_thanks_button

data class AddPhotosState(
    var button:MutableState<DrawableResource> = mutableStateOf(Res.drawable.no_thanks_button)
)
