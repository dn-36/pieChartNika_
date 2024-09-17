package org.example.project.presentation.pie_chart_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen

object OkIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)
    }
}