package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel

sealed class ChoosingCategoryIntents {
    data class ChoosingCategory(val index:Int,val category:String):ChoosingCategoryIntents()
    object Next:ChoosingCategoryIntents()
    object Back:ChoosingCategoryIntents()
}