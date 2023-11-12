package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(indices = [Index("email", "id", unique = true)])
data class UsersAdsRelationDataModel(
  @PrimaryKey val connectionId: UUID,
  val email: String,
  val id: UUID,
)