package io.readian.android.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.readian.android.core.database.model.UserDataModel

@Dao
interface UserDao {

  @Query("SELECT * FROM UserDataModel WHERE email IS :email AND password IS :password")
  suspend fun getUser(
    email: String,
    password: String,
  ): UserDataModel?

  @Insert
  suspend fun insertUser(user: UserDataModel)
}
