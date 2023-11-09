package io.readian.android.core.data

import io.readian.android.core.database.UniAppDatabase
import io.readian.android.core.database.model.UserDataModel
import javax.inject.Inject

class UniAppRepository @Inject constructor(
  private val database: UniAppDatabase,
) {
  suspend fun saveUser(
    username: String,
    email: String,
    password: String,
  ) {
    database.userDao().insertUser(
      UserDataModel(
        username = username,
        email = email,
        password = password,
      )
    )
  }

  suspend fun getUser(
    email: String,
    password: String,
  ): UserDataModel? {
    return database.userDao().getUser(
      email = email,
      password = password,
    )
  }
}
