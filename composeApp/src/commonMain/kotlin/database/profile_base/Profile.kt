package database.profile_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.example.project.utils.Goal


@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val gender: String,
    val img: ByteArray
)
