package org.example.project.presentation.wish_list.target_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.GoalObject
import org.example.project.presentation.wish_list.amount_savings_feature.screen.AmountSavingsScreen
import org.example.project.presentation.wish_list.target_feature.viewmodel.TargetViewModel

object NextIntent {
    fun execute(target:String){
        if(target.length != 0){
            GoalObject.target.value = target
        StaticDate.navigator.push(AmountSavingsScreen)}
        else{
            TargetViewModel.targetState = TargetViewModel.targetState.copy(
                toast = mutableStateOf(true)
            )
        }
    }
}