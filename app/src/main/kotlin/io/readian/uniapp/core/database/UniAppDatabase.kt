package io.readian.uniapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.readian.uniapp.core.database.dao.UserDao
import io.readian.uniapp.core.database.model.UserDataModel

@Database(
    entities = [
        UserDataModel::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class UniAppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
