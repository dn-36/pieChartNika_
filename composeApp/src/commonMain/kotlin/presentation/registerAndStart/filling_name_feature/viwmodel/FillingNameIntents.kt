package org.example.project.presentation.registerAndStart.filling_name_feature.viwmodel

sealed class FillingNameIntents {
    data class Next(val name:String):FillingNameIntents()
}