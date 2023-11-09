package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserDataModel(
  @PrimaryKey val email: String,
  val username: String,
  val password: String,
)

//username | email        | password
//----------------------------------
//ibragim  | ibra@mail.ru | 123456
//milana   | milana@mil.ru| sdfsdfs