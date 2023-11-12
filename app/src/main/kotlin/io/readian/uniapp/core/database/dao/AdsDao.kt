package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.readian.uniapp.core.database.model.AdDataModel
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface AdsDao {
  @Upsert
  suspend fun insert(item: AdDataModel)

  @Query("SELECT * FROM AdDataModel")
  fun getAll(): Flow<List<AdDataModel>>

  @Query("SELECT * FROM AdDataModel where email IS :email")
  fun getForUserFlow(email: String): Flow<List<AdDataModel>>

  @Query("SELECT * FROM AdDataModel where email IS :email")
  fun getCreatedAdsForUser(email: String): Flow<List<AdDataModel>>

  @Query("SELECT * FROM AdDataModel WHERE name IS :name")
  suspend fun selectByName(name: String): AdDataModel?

  @Query("DELETE FROM AdDataModel WHERE id IS :id")
  suspend fun deleteAd(id: UUID)
}
