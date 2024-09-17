package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object DoneIntent {
    fun execute() {
        CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
            loan = mutableStateOf(1f),
            detailLoan = mutableStateOf(false)
        )
    }
}