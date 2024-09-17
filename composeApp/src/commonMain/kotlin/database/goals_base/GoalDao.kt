package database.goals_base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import database.wallets_base.Person

@Dao
interface GoalDao {

        @Insert
        suspend fun upsert(goal: Goal)


        @Delete
        suspend fun delete(goal: Goal)

        @Query("SELECT * FROM goal")
        suspend fun getAllGoal(): List<Goal>

        @Update
        suspend fun update(goal: Goal)

}