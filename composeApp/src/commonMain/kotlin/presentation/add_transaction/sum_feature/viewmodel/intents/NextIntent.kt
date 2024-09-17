package org.example.project.presentation.add_transaction.sum_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.finish_fetaure.screen.FinishScreen

object NextIntent {
    fun execute(sum:String){
        StaticDate.navigator.push(FinishScreen)
        DataTransaction.sum.value = sum
    }
}