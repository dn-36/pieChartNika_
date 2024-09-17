package database.wallets_base

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.example.project.utils.Wallets

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
val wallet: Wallets
)
