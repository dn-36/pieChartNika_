package com.plcoding.room_cmp.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.goals_base.GoalDataBase
import database.profile_base.ProfileDataBase
import database.wallets_base.PeopleDatabase

fun getPeopleDatabase(context: Context): PeopleDatabase {
    val dbFile = context.getDatabasePath("people.db")
    return Room.databaseBuilder<PeopleDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
fun getGoalDatabase(context: Context): GoalDataBase {
    val dbFile = context.getDatabasePath("goal.db")
    return Room.databaseBuilder<GoalDataBase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
fun getProfileDatabase(context: Context): ProfileDataBase {
    val dbFile = context.getDatabasePath("profile.db")
    return Room.databaseBuilder<ProfileDataBase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}