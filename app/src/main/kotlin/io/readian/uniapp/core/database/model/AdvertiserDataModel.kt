package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AdvertiserDataModel(
  val username: String,
  @PrimaryKey val name: String,
  val price: Int,
  val description: String,
  val image: String,
  val category: String,
)
