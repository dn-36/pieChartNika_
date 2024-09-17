package database.goals_base.converter

import androidx.compose.ui.graphics.ImageBitmap
import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.project.utils.Goal
import org.example.project.utils.Wallets

class GoalConverters {
    @TypeConverter
    fun fromGoal(value: Goal): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toGoal(value: String): Goal {
        return Json.decodeFromString(value)
    }
}