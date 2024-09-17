package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import database.goals_base.Goal
import database.wallets_base.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.wallets_feature.edit_wallet_feature.viewmodel.EditWalletViewModel
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.screen.AddOrDeleteScreen
import org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel.AddOrDeleteViewModel
import org.example.project.presentation.wish_list.detail_goal_feature.screen.DetailGoalScreen

object DoneIntent {
    fun execute(sum:String){
        var newSum = 0
        if(sum.length != 0){
            if(AddOrDeleteViewModel.addOrDeleteState.alphaAdd.value == 1f){
               newSum = AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].already + sum.toInt()
                AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].already = newSum
                AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].transactions += 1


                val indexNow = AddOrDeleteViewModel(StaticDate).date.goalNow.value+1
                val editedGoal = AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value]
                CoroutineScope(Dispatchers.IO).launch  {
                    ServiceLocator.goalDao.update(Goal( id = indexNow, goal = editedGoal))
                }

                StaticDate.navigator.push(DetailGoalScreen)
            }
            else if(AddOrDeleteViewModel.addOrDeleteState.alphaDelete.value == 1f){
                if(sum.toInt() > AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].already){
                    AddOrDeleteViewModel.addOrDeleteState = AddOrDeleteViewModel.addOrDeleteState.copy(
                        toast = mutableStateOf(true),
                        toastText = mutableStateOf("The amount of accumulated\nmoney cannot be\nlower than zero")
                    )
                }
                else{
                newSum = AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].already - sum.toInt()
                    AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].already = newSum
                    AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value].transactions += 1

                    val indexNow = AddOrDeleteViewModel(StaticDate).date.goalNow.value+1
                    val editedGoal = AddOrDeleteViewModel(StaticDate).date.listGoals[AddOrDeleteViewModel(StaticDate).date.goalNow.value]
                    CoroutineScope(Dispatchers.IO).launch  {
                        ServiceLocator.goalDao.update(Goal( id = indexNow, goal = editedGoal))
                    }

                    StaticDate.navigator.push(DetailGoalScreen)
                }
            }
        }
        else{
            AddOrDeleteViewModel.addOrDeleteState = AddOrDeleteViewModel.addOrDeleteState.copy(
                toast = mutableStateOf(true),
                toastText = mutableStateOf("Fill in the field")
            )
        }
    }
}