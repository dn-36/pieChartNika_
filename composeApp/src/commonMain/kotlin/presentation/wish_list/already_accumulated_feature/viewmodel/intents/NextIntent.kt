package org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import org.example.project.core.StaticDate
import org.example.project.presentation.wish_list.GoalObject
import org.example.project.presentation.wish_list.already_accumulated_feature.screen.AlreadyAccumulatedScreen
import org.example.project.presentation.wish_list.already_accumulated_feature.viewmodel.AlreadyAccumulatedViewModel
import org.example.project.presentation.wish_list.finish_wish_feature.screen.FinishWishScreen
import org.example.project.presentation.wish_list.finish_wish_feature.viewmodel.FinishWishViewModel

object NextIntent {
    fun execute(already:String){
        if(already.length != 0 && already.toInt() < GoalObject.sum.value){
            GoalObject.already.value = already.toInt()
            FinishWishViewModel(StaticDate).date.isUsedFinishWish.value = true
        StaticDate.navigator.push(FinishWishScreen)}
        else if(already.length == 0){
            AlreadyAccumulatedViewModel.alreadyAccumulatedState = AlreadyAccumulatedViewModel.alreadyAccumulatedState.copy(
                toast = mutableStateOf(true),
                textToast = mutableStateOf("Fill in the field")
            )
        }
        else if(already.toInt() > GoalObject.sum.value){
            AlreadyAccumulatedViewModel.alreadyAccumulatedState = AlreadyAccumulatedViewModel.alreadyAccumulatedState.copy(
                toast = mutableStateOf(true),
                textToast = mutableStateOf("the accumulated amount\ncannot exceed the\nfinal amount")
            )
        }
    }
}