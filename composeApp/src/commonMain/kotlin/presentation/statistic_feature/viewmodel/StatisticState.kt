package org.example.project.presentation.statistic_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.utils.Transaction

data class StatisticState(
    var diagram: MutableState<Float> = mutableStateOf(1F),
    var moneyBox: MutableState<Float> = mutableStateOf(0F),
    var transactions: MutableState<Float> = mutableStateOf(0F),
    var index: MutableState<Int> = mutableStateOf(8),
    var incomeSum: MutableState<Int> = mutableStateOf(0),
    var percentIncome:MutableState<Float> = mutableStateOf(0f),
    var percentExpense:MutableState<Float> = mutableStateOf(0f),
    var listTransactions:MutableList<Transaction> = mutableListOf(),
    var expenseSum: MutableState<Int> = mutableStateOf(0),
    var listMonths: MutableList<String> = mutableListOf("January","February","March","April","May","June","July","August",
        "September","October","November","December"),
    var listHeight: MutableList<Pair<Int,Int>> = mutableListOf(Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0)
    ,Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0),Pair(0,0)),
)
