package org.example.project.presentation.registerAndStart.start_feature.viewmodel.intents

import ServiceLocator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.StaticDate
import org.example.project.presentation.menu_feature.screen.MenuScreen
import org.example.project.presentation.registerAndStart.welcome_feature.screen.WelcomeScreen

object StartIntent {
    fun execute(){
        CoroutineScope(Dispatchers.IO).launch {
            if (ServiceLocator.peopleDao.getAllPeople().size != 0) {
                StaticDate.navigator.push(MenuScreen)
            } else {
                StaticDate.navigator.push(WelcomeScreen)
            }
        }
    }
}