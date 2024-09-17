package org.example.project.presentation.menu_feature.viewmodel.intents

import org.example.project.core.StaticDate
import org.example.project.presentation.calculator_feature.screen.CalculatorScreen

object CalculatorIntent {
    fun execute(){
        StaticDate.navigator.push(CalculatorScreen)
    }
}