package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class AdDataModel(
  @PrimaryKey val id: UUID = UUID.randomUUID(),
  val email: String,
  val name: String,
  val price: Int,
  val description: String,
  val image: String,
  val category: String,
)
