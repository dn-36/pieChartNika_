package org.example.project.presentation.statistic_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.statistic_feature.viewmodel.StatisticViewModel

object SetDiagramIntent {
    fun execute(){
        if(StatisticViewModel(StaticDate).date.isUsedStatistic.value) {
            if (StatisticViewModel.statisticState.diagram.value == 1F) {
                val listIncome = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                val listExpense = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                for (n in StatisticViewModel(StaticDate).date.listWallets[StatisticViewModel(StaticDate).date.indexWalletNow.value].listTransactionsExpense) {
                    if (n.month == StatisticViewModel.statisticState.listMonths[StatisticViewModel.statisticState.index.value]) {
                        when (n.day.toInt()) {
                            in 1..3 -> {
                                listExpense[0] += n.sum.toInt()
                            }

                            in 4..6 -> {
                                listExpense[1] += n.sum.toInt()
                            }

                            in 7..9 -> {
                                listExpense[2] += n.sum.toInt()
                            }

                            in 10..12 -> {
                                listExpense[3] += n.sum.toInt()
                            }

                            in 13..15 -> {
                                listExpense[4] += n.sum.toInt()
                            }

                            in 16..18 -> {
                                listExpense[5] += n.sum.toInt()
                            }

                            in 19..21 -> {
                                listExpense[6] += n.sum.toInt()
                            }

                            in 22..24 -> {
                                listExpense[7] += n.sum.toInt()
                            }

                            in 25..27 -> {
                                listExpense[8] += n.sum.toInt()
                            }

                            in 28..31 -> {
                                listExpense[9] += n.sum.toInt()
                            }
                        }
                    }
                }
                for (i in StatisticViewModel(StaticDate).date.listWallets[StatisticViewModel(StaticDate).date.indexWalletNow.value].listTransactionsIncome) {
                    if (i.month == StatisticViewModel.statisticState.listMonths[StatisticViewModel.statisticState.index.value]) {
                        when (i.day.toInt()) {
                            in 1..3 -> {
                                listIncome[0] += i.sum.toInt()
                            }

                            in 4..6 -> {
                                listIncome[1] += i.sum.toInt()
                            }

                            in 7..9 -> {
                                listIncome[2] += i.sum.toInt()
                            }

                            in 10..12 -> {
                                listIncome[3] += i.sum.toInt()
                            }

                            in 13..15 -> {
                                listIncome[4] += i.sum.toInt()
                            }

                            in 16..18 -> {
                                listIncome[5] += i.sum.toInt()
                            }

                            in 19..21 -> {
                                listIncome[6] += i.sum.toInt()
                            }

                            in 22..24 -> {
                                listIncome[7] += i.sum.toInt()
                            }

                            in 25..27 -> {
                                listIncome[8] += i.sum.toInt()
                            }

                            in 28..31 -> {
                                listIncome[9] += i.sum.toInt()
                            }
                        }
                    }
                }
                for (h in listExpense.indices) {
                    if (listExpense[h] > listIncome[h] && listIncome[h] != 0) {
                        StatisticViewModel.statisticState.listHeight[h] = Pair(50, 140)
                    } else if (listExpense[h] > listIncome[h] && listIncome[h] == 0) {
                        StatisticViewModel.statisticState.listHeight[h] = Pair(0, 190)
                    } else if (listExpense[h] < listIncome[h] && listExpense[h] == 0) {
                        StatisticViewModel.statisticState.listHeight[h] = Pair(190, 0)
                    } else if (listExpense[h] < listIncome[h] && listExpense[h] != 0) {
                        StatisticViewModel.statisticState.listHeight[h] = Pair(140, 50)
                    }
                }

                val incomeSum = listIncome[0] + listIncome[1] + listIncome[2] + listIncome[3]
                +listIncome[4] + listIncome[5] + listIncome[6] + listIncome[7] + listIncome[8] + listIncome[9]

                val expenseSum = listExpense[0] + listExpense[1] + listExpense[2] + listExpense[3]
                +listExpense[4] + listExpense[5] + listExpense[6] + listExpense[7] + listExpense[8] + listExpense[9]


                val sum = incomeSum + expenseSum

                var percentIncome = incomeSum.toFloat() / sum
                var percentExpense = expenseSum.toFloat() / sum

                StatisticViewModel.statisticState = StatisticViewModel.statisticState.copy(
                    incomeSum = mutableStateOf(incomeSum),
                    expenseSum = mutableStateOf(expenseSum),
                    percentIncome = mutableStateOf(percentIncome),
                    percentExpense = mutableStateOf(percentExpense)
                )
                StatisticViewModel(StaticDate).date.isUsedStatistic.value = false
            }
        }
    }
}