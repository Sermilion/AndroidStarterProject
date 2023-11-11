package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.readian.uniapp.core.database.model.AdDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AdvertisersDao {
  @Insert
  suspend fun insert(item: AdDataModel)

  @Query("SELECT * FROM AdDataModel")
  fun getAll(): Flow<List<AdDataModel>>

  @Query("SELECT * FROM AdDataModel WHERE name IS :name")
  suspend fun selectByName(name: String): AdDataModel?
}
