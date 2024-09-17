package org.example.project.presentation.add_transaction.name_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.date_feature.screen.DateScreen
import org.example.project.presentation.menu_feature.screen.MenuScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(DateScreen)
    }
}