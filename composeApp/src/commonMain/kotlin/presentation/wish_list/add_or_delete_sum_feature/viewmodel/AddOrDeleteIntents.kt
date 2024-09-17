package org.example.project.presentation.wish_list.add_or_delete_sum_feature.viewmodel

sealed class AddOrDeleteIntents {
    data class Done(val sum:String):AddOrDeleteIntents()
    object Back:AddOrDeleteIntents()
    object Add:AddOrDeleteIntents()
    object Delete:AddOrDeleteIntents()
}