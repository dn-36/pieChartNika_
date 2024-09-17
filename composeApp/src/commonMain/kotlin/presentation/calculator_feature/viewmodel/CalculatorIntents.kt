package org.example.project.presentation.calculator_feature.viewmodel

sealed class CalculatorIntents {
    object OpenMonth:CalculatorIntents()
    object OpenPercentMonth:CalculatorIntents()
    data class Next(val sum:String,val term:String,val rate:String):CalculatorIntents()
    object Back:CalculatorIntents()
    object Simple:CalculatorIntents()
    object Done:CalculatorIntents()
    object Loan:CalculatorIntents()
    object SetDetailLoan:CalculatorIntents()
    data class ChoosingTerm(val term:String):CalculatorIntents()
    data class ChoosingRate(val rate:String):CalculatorIntents()
}