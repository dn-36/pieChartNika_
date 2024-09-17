package com.plcoding.room_cmp

import App
import ServiceLocator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.room_cmp.database.getGoalDatabase
import com.plcoding.room_cmp.database.getPeopleDatabase
import com.plcoding.room_cmp.database.getProfileDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val daoPeople = getPeopleDatabase(applicationContext).peopleDao()
        val daoGoal = getGoalDatabase(applicationContext).goalDao()
        val daoProfile = getProfileDatabase(applicationContext).profileDao()
        ServiceLocator.peopleDao = daoPeople
        ServiceLocator.goalDao = daoGoal
        ServiceLocator.profileDao = daoProfile
        setContent {
            App()
        }
    }
}