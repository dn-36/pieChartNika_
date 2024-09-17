package org.example.project.presentation.calculator_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CalculatorState(
    var openMonth:MutableState<Boolean> = mutableStateOf(false),
    var openPercentMonth:MutableState<Boolean> = mutableStateOf(false),
    var detailLoan:MutableState<Boolean> = mutableStateOf(false),
    var loan:MutableState<Float> = mutableStateOf(0F),
    var simple:MutableState<Float> = mutableStateOf(1F),
    var percent:MutableState<String> = mutableStateOf("% Year"),
    var month:MutableState<String> = mutableStateOf("Year"),
    var toast:MutableState<Boolean> = mutableStateOf(false),
    var monthlyPayment:MutableState<Int> = mutableStateOf(0),
    var overpayment:MutableState<Int> = mutableStateOf(0),
    var totalOverpayment:MutableState<Int> = mutableStateOf(0),
    var totalLoanCoast:MutableState<Int> = mutableStateOf(0),
    var sum:MutableState<Int> = mutableStateOf(0),
    var totalTerm:MutableState<Int> = mutableStateOf(0),
    var totalRate:MutableState<Double> = mutableStateOf(0.0),

    )
