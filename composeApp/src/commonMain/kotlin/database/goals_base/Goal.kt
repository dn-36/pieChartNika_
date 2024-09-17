package database.goals_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.example.project.utils.Goal
import org.example.project.utils.Wallets

@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val goal: Goal
)
