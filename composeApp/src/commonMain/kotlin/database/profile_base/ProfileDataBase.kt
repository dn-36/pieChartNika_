package database.profile_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.goals_base.Goal
import database.goals_base.GoalDao
import database.goals_base.converter.GoalConverters


@Database(
    entities = [Profile::class],
    version = 1
)
@TypeConverters(GoalConverters::class)
abstract class ProfileDataBase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao

}