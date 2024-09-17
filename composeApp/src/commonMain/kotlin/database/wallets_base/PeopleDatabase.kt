package database.wallets_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.wallets_base.converter.WalletsConverters

@Database(
    entities = [Person::class],
    version = 1
)
@TypeConverters(WalletsConverters::class)
abstract class PeopleDatabase: RoomDatabase() {

    abstract fun peopleDao(): PeopleDao

}