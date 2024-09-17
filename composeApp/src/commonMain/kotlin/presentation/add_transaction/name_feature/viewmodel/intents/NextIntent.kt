package org.example.project.presentation.add_transaction.name_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.utils.DataTransaction
import org.example.project.presentation.add_transaction.sum_feature.screen.SumScreen

object NextIntent {
    fun execute(name:String){
        StaticDate.navigator.push(SumScreen)
        DataTransaction.name.value = name
    }
}