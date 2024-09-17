package org.example.project.presentation.add_transaction.choosing_category_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen

object BackButtonIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)
    }
}