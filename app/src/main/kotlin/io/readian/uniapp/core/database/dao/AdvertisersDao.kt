package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.readian.uniapp.core.database.model.AdvertiserDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AdvertisersDao {
  @Insert
  suspend fun insert(item: AdvertiserDataModel)

  @Query("SELECT * FROM AdvertiserDataModel")
  fun getAll(): Flow<List<AdvertiserDataModel>>

  @Query("SELECT * FROM AdvertiserDataModel WHERE name IS :name")
  suspend fun selectByName(name: String): AdvertiserDataModel?
}
