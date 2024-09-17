package org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.GoalObject
import org.example.project.presentation.wish_list.already_accumulated_feature.screen.AlreadyAccumulatedScreen
import org.example.project.presentation.wish_list.amount_savings_feature.viewmodel.AmountSavingsViewModel

object NextIntent {
    fun execute(amount:String){
        if(amount.length != 0){
            GoalObject.sum.value = amount.toInt()
        StaticDate.navigator.push(AlreadyAccumulatedScreen)}
        else{
            AmountSavingsViewModel.amountSavingsState = AmountSavingsViewModel.amountSavingsState.copy(
                toast = mutableStateOf(true)
            )
        }
    }
}