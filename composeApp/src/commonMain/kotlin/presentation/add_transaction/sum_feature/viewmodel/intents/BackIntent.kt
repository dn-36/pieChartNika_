package org.example.project.presentation.add_transaction.sum_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.add_transaction.choosing_icon_feature.screen.ChoosingIconScreen
import org.example.project.presentation.add_transaction.name_feature.screen.NameScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(NameScreen)
    }
}