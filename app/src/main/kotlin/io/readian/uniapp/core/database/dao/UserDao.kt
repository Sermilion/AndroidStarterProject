package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.readian.uniapp.core.database.model.UserAdsDataModel
import io.readian.uniapp.core.database.model.UserDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

  @Query("SELECT * FROM UserDataModel WHERE email IS :email AND password IS :password")
  suspend fun getUser(
    email: String,
    password: String,
  ): UserDataModel?

  @Insert
  suspend fun insertUser(user: UserDataModel)

  @Query("UPDATE UserDataModel SET loggedIn = :loggedIn WHERE email IS :email")
  suspend fun setUserLogged(email: String, loggedIn: Boolean)

  @Query("SELECT * FROM UserDataModel WHERE loggedIn IS 1")
  fun getLoggedUserFlow(): Flow<UserDataModel>

  @Query("SELECT * FROM UserDataModel WHERE loggedIn IS 1")
  suspend fun getLoggedUser(): UserDataModel?

  @Query("SELECT * FROM UserDataModel WHERE email IS :email")
  fun getUserAndAds(email: String): Flow<UserAdsDataModel?>
}
