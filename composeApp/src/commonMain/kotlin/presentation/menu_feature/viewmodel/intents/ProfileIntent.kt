package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.pie_chart_feature.screen.PieChartScreen
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartViewModel
import org.example.project.presentation.profile_feature.screen.ProfileScreen

object ProfileIntent {
    fun execute(){
        StaticDate.navigator.push(ProfileScreen)
    }
}