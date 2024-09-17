package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object ChoosingRateIntent {
    fun execute(rate:String){
        CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
            percent = mutableStateOf(rate),
            openPercentMonth = mutableStateOf(false)
        )
    }
}