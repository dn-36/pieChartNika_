package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents.AddOrDeleteIntent
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents.DeleteGoalIntent
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents.NoIntent
import org.example.project.presentation.wish_list.detail_goal_feature.viewmodel.intents.YesIntent
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents.DetailGoalIntent

class DetailGoalViewModel(val date: StaticDateApi): ViewModel() {
    companion object{
        var detailGoalState by mutableStateOf(DetailGoalState())
    }
    fun processIntent(intents: DetailGoalIntents){
        when(intents){
            is DetailGoalIntents.AddOrDeleteSum -> {AddOrDeleteIntent.execute()}
            is DetailGoalIntents.Back -> {BackIntent.execute()}
            is DetailGoalIntents.DeleteGoal -> {DeleteGoalIntent.execute()}
            is DetailGoalIntents.No -> {NoIntent.execute()}
            is DetailGoalIntents.Yes -> {YesIntent.execute()}
        }
    }
}