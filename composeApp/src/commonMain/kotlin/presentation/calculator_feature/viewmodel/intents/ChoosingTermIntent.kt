package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object ChoosingTermIntent {
    fun execute(term:String){
        CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
            month = mutableStateOf(term),
            openMonth = mutableStateOf(false)
        )
    }
}