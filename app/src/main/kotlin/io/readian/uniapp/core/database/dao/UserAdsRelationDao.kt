package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.readian.uniapp.core.database.model.UsersAdsRelationDataModel
import java.util.UUID

@Dao
interface UserAdsRelationDao {

  @Upsert
  suspend fun insert(model: UsersAdsRelationDataModel)

  @Query("DELETE FROM UsersAdsRelationDataModel WHERE id IS :id")
  suspend fun delete(id: UUID)
}
