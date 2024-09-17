package org.example.project.presentation.registerAndStart.welcome_feature.viewmodel.inetnts

import org.example.project.core.StaticDate
import org.example.project.presentation.registerAndStart.filling_name_feature.screen.FillingNameScreen

object StartIntent {
    fun execute(){
        StaticDate.navigator.push(FillingNameScreen)
    }
}