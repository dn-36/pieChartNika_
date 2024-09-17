package org.example.project.presentation.menu_feature.viewmodel.intents

import androidx.compose.ui.graphics.Color
import org.example.project.presentation.menu_feature.viewmodel.MenuViewModel

object ChoosingCalendarIntent {
    fun execute(index:Int){
        val newlList = mutableListOf(Color.White,Color.White,Color.White,Color.White)
         newlList[index] = Color(0xFFF0F2F6)

        MenuViewModel.menuState = MenuViewModel.menuState.copy(
            colorCalendar = newlList
        )
    }

}