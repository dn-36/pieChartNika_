package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object OpenMonthIntent {
    fun execute(){
        if(!CalculatorViewModel.calculatorState.openMonth.value) {
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                openMonth = mutableStateOf(true)
            )
        }
        else{
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                openMonth = mutableStateOf(false)
            )
        }
    }
}