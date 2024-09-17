package database.wallets_base.converter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.project.utils.SumWallet
import org.example.project.utils.Transaction
import org.example.project.utils.Wallets

class WalletsConverters {

    // Преобразование объекта Wallets в строку (если необходимо сохранять как объект)
    @TypeConverter
    fun fromWallets(value: Wallets): String {
        return Json.encodeToString(value)
    }

    // Преобразование строки в объект Wallets
    @TypeConverter
    fun toWallets(value: String): Wallets {
        return Json.decodeFromString(value)
    }
}
