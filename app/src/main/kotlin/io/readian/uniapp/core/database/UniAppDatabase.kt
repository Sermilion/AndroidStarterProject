package io.readian.uniapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.readian.uniapp.core.database.dao.AdsDao
import io.readian.uniapp.core.database.dao.UserDao
import io.readian.uniapp.core.database.dao.UserAdsRelationDao
import io.readian.uniapp.core.database.model.AdDataModel
import io.readian.uniapp.core.database.model.UserDataModel
import io.readian.uniapp.core.database.model.UsersAdsRelationDataModel

@Database(
    entities = [
        UserDataModel::class,
        AdDataModel::class,
        UsersAdsRelationDataModel::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class UniAppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun adsDao(): AdsDao

    abstract fun userAdsRelationDao(): UserAdsRelationDao

}
