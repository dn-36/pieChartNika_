package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.goals_base.GoalDataBase
import database.profile_base.ProfileDataBase
import database.wallets_base.PeopleDatabase
import platform.Foundation.NSHomeDirectory

fun getPeopleDatabase(): PeopleDatabase {
    val dbFile = NSHomeDirectory() + "/people.db"
    return Room.databaseBuilder<PeopleDatabase>(
        name = dbFile,
        factory = { PeopleDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}

fun getGoalDatabase(): GoalDataBase {
    val dbFile = NSHomeDirectory() + "/goal.db"
    return Room.databaseBuilder<GoalDataBase>(
        name = dbFile,
        factory = { GoalDataBase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
fun getProfileDatabase(): ProfileDataBase {
    val dbFile = NSHomeDirectory() + "/profile.db"
    return Room.databaseBuilder<ProfileDataBase>(
        name = dbFile,
        factory = { ProfileDataBase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}