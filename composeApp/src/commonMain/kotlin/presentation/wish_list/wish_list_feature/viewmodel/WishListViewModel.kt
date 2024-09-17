package org.example.project.presentation.wish_list.wish_list_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDateApi
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents.AddGoalsIntent
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents.BackIntent
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents.DetailGoalIntent
import org.example.project.presentation.wish_list.wish_list_feature.viewmodel.intents.SetWishListIntent

class WishListViewModel(val date: StaticDateApi): ViewModel() {
companion object{
    var wishListState by mutableStateOf(WishListState())

}
    fun processIntent(intents: WishListIntents){
        when(intents){
            is WishListIntents.AddNewGoals -> {AddGoalsIntent.execute()}
            is WishListIntents.Back -> {BackIntent.execute()}
            is WishListIntents.SetScreen -> {SetWishListIntent.execute()}
            is WishListIntents.DetailGoal -> {DetailGoalIntent.execute(intents.index)}
        }
    }
}