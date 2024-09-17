package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object SimpleIntent {
    fun execute(){
        CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
            loan = mutableStateOf(0f),
            simple = mutableStateOf(1f)
        )
    }
}