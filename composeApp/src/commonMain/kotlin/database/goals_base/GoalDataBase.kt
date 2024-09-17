package database.goals_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.goals_base.converter.GoalConverters
import database.wallets_base.PeopleDao
import database.wallets_base.Person
import database.wallets_base.converter.WalletsConverters


@Database(
    entities = [Goal::class],
    version = 1
)
@TypeConverters(GoalConverters::class)
abstract class GoalDataBase : RoomDatabase() {

        abstract fun goalDao(): GoalDao
}