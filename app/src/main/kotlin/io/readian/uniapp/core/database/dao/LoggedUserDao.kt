package io.readian.uniapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.readian.uniapp.core.database.model.LoggedUser
import kotlinx.coroutines.flow.Flow

@Dao
interface LoggedUserDao {

  @Insert
  suspend fun saveLoggedUser(user: LoggedUser)

  @Query("SELECT * FROM LoggedUser")
  fun getLoggedUser(): Flow<LoggedUser?>

  @Query("DELETE FROM LoggedUser")
  suspend fun deleteLoggedUser()

}
