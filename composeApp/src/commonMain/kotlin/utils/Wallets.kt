package org.example.project.utils

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource


@Serializable
data class Wallets(var sum:String,var name:String,var currency:String
,var listTransactionsIncome:MutableList<Transaction>,var listTransactionsExpense:MutableList<Transaction>
,var listTransactions:MutableList<SumWallet>)
