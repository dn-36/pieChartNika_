package org.example.project.presentation.pie_chart_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.pie_chart_feature.viewmodel.intents.OkIntent
import org.example.project.presentation.pie_chart_feature.viewmodel.intents.SetPieChartIntent

class PieChartViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var pieChartState by mutableStateOf(PieChartState())
    }
    fun processIntent(intent: PieChartIntents){
        when(intent){
            is PieChartIntents.Ok -> {OkIntent.execute()}
            is PieChartIntents.SetScreen -> {SetPieChartIntent.execute()}
        }
    }
}