package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel
import org.example.project.presentation.pie_chart_feature.screen.PieChartScreen
import org.example.project.presentation.pie_chart_feature.viewmodel.PieChartViewModel

object PieChartIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedPieChart.value = true
        StaticDate.navigator.push(PieChartScreen)
    }
}