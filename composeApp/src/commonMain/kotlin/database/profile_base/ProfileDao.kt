package database.profile_base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import database.goals_base.Goal


@Dao
interface ProfileDao {

    @Insert
    suspend fun upsert(profile: Profile)


    @Delete
    suspend fun delete(profile: Profile)

    @Query("SELECT * FROM profile")
    suspend fun getAllProfile(): Profile

    @Update
    suspend fun update(profile: Profile)

}