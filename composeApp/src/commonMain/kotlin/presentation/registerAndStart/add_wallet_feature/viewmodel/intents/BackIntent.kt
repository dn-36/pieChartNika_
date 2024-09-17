package org.example.project.presentation.registerAndStart.add_wallet_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.registerAndStart.gender_feature.screen.GenderScreen

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(GenderScreen)

    }
}