package io.readian.uniapp.core.data.repository

import io.readian.uniapp.core.database.UniAppDatabase
import io.readian.uniapp.core.database.model.UserDataModel
import io.readian.uniapp.core.database.model.UserType
import javax.inject.Inject

class UniAppRepository @Inject constructor(
  private val database: UniAppDatabase,
) {
  suspend fun saveUser(
    username: String,
    email: String,
    password: String,
    type: UserType,
  ) {
    database.userDao().insertUser(
      UserDataModel(
        username = username,
        email = email,
        password = password,
        type = type,
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
