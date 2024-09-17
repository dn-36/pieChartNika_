package org.example.project.presentation.calculator_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.calculator_feature.screen.CalculatorScreen
import org.example.project.presentation.menu_feature.screen.MenuScreen

object BackIntent {
    fun execute() {
        StaticDate.navigator.push(MenuScreen)
    }
}