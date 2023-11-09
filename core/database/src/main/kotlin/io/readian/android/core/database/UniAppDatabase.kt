package io.readian.android.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.readian.android.core.database.dao.UserDao
import io.readian.android.core.database.model.UserDataModel

@Database(
    entities = [
        UserDataModel::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class UniAppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}