package org.example.project.presentation.calculator_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.presentation.calculator_feature.viewmodel.CalculatorViewModel

object NextIntent {
    fun execute(sum:String,term:String,rate:String) {
        if(sum.length != 0 && term.length != 0 && rate.length != 0) {
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                detailLoan = mutableStateOf(true),
                simple = mutableStateOf(0f),
                loan = mutableStateOf(0f),
                sum = mutableStateOf(sum.toInt()),
                totalTerm = mutableStateOf(term.toInt()),
                totalRate = mutableStateOf(rate.toDouble())
            )
        }
        else{
            CalculatorViewModel.calculatorState = CalculatorViewModel.calculatorState.copy(
                toast = mutableStateOf(true)
            )
        }
    }
}