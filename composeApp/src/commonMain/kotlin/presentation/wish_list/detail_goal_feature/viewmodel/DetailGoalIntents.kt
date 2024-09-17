package org.example.project.presentation.wish_list.detail_goal_feature.viewmodel

sealed class DetailGoalIntents {
    object AddOrDeleteSum:DetailGoalIntents()
    object Back:DetailGoalIntents()
    object DeleteGoal:DetailGoalIntents()
    object Yes:DetailGoalIntents()
    object No:DetailGoalIntents()
}