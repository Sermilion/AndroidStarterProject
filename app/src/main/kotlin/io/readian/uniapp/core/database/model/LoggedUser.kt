package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoggedUser(
  @PrimaryKey val email: String,
  val password: String,
  val type: UserType,
)
