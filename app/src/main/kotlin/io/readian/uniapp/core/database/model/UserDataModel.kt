package io.readian.uniapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserDataModel(
  @PrimaryKey val email: String,
  val username: String,
  val password: String,
  val type: UserType,
)

enum class UserType {
  Advertiser,
  Company,
  None,
}

//username | email        | password |  type
//----------------------------------------------
//ibragim  | ibra@mail.ru | 123456   | company
//milana   | milana@mil.ru| sdfsdfs  | advertiser