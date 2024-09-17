package org.example.project.presentation.pie_chart_feature.viewmodel

sealed class PieChartIntents {
    object Ok:PieChartIntents()
    object SetScreen:PieChartIntents()
}