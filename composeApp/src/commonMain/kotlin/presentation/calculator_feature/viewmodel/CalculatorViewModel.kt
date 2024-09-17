package org.example.project.presentation.calculator_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.calculator_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.ChoosingRateIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.ChoosingTermIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.DoneIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.LoanIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.NextIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.OpenMonthIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.OpenPercentMonthIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.SetDetailLoanIntent
import org.example.project.presentation.calculator_feature.viewmodel.intents.SimpleIntent

class CalculatorViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var calculatorState by mutableStateOf(CalculatorState())
    }
    fun processIntent(intents: CalculatorIntents){
        when(intents){
            is CalculatorIntents.Back -> {BackIntent.execute()}
            is CalculatorIntents.Next -> {NextIntent.execute(intents.sum,intents.term,intents.rate)}
            is CalculatorIntents.OpenMonth -> {OpenMonthIntent.execute()}
            is CalculatorIntents.OpenPercentMonth -> {OpenPercentMonthIntent.execute()}
            is CalculatorIntents.Simple -> {SimpleIntent.execute()}
            is CalculatorIntents.Loan -> {LoanIntent.execute()}
            is CalculatorIntents.Done -> {DoneIntent.execute()}
            is CalculatorIntents.SetDetailLoan -> {SetDetailLoanIntent.execute()}
            is CalculatorIntents.ChoosingRate -> {ChoosingRateIntent.execute(intents.rate)}
            is CalculatorIntents.ChoosingTerm -> {ChoosingTermIntent.execute(intents.term)}
        }
    }
}