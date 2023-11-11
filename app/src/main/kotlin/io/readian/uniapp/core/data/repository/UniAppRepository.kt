package io.readian.uniapp.core.data.repository

import io.readian.uniapp.core.database.UniAppDatabase
import io.readian.uniapp.core.database.model.AdDataModel
import io.readian.uniapp.core.database.model.UserDataModel
import io.readian.uniapp.core.database.model.UserType
import kotlinx.coroutines.flow.Flow
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

  fun getAds(): Flow<List<AdDataModel>> {
    return database.advertisersDao().getAll()
  }

  suspend fun getAdsByName(name: String): AdDataModel? {
    return database.advertisersDao().selectByName(name)
  }

  suspend fun saveAd(
    name: String,
    price: Int,
    description: String,
    image: String,
    category: String,
    username: String,
  ) {
    database.advertisersDao().insert(
      AdDataModel(
        name = name,
        price = price,
        description = description,
        image = image,
        category = category,
        username = username,
      )
    )
  }
}
