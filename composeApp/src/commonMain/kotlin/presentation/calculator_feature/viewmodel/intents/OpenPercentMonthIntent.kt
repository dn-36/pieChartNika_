package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object OpenPercentMonthIntent {
    fun execute(){
        if(!CalculatorViewModel.calculatorState.openPercentMonth.value){
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                openPercentMonth = mutableStateOf(true)
            )
        }
        else{
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                openPercentMonth = mutableStateOf(false)
            )
        }
    }
}