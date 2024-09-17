package org.example.project.presentation.wish_list.target_feature.viewmodel

sealed class TargetIntents {
    data class Next(val target:String):TargetIntents()
    object Back:TargetIntents()
}