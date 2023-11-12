package io.readian.uniapp.core.data.repository

import android.database.sqlite.SQLiteConstraintException
import io.readian.uniapp.core.database.UniAppDatabase
import io.readian.uniapp.core.database.model.AdDataModel
import io.readian.uniapp.core.database.model.UserAdsDataModel
import io.readian.uniapp.core.database.model.UserDataModel
import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.database.model.UsersAdsRelationDataModel
import kotlinx.coroutines.flow.Flow
import java.util.UUID
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
        loggedIn = false,
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
    return database.adsDao().getAll()
  }

  fun getCreatedAdsForUser(email: String): Flow<List<AdDataModel>> {
    return database.adsDao().getCreatedAdsForUser(email)
  }

  fun getUserWithAds(email: String): Flow<UserAdsDataModel?> {
    return database.userDao().getUserAndAds(email)
  }

  suspend fun saveAd(
    adId: UUID,
    email: String,
  ) {
    try {
      database.userAdsRelationDao().insert(
        UsersAdsRelationDataModel(
          email = email,
          id = adId,
          connectionId = UUID.randomUUID(),
        )
      )
    } catch (e: SQLiteConstraintException) {
      // ignore
    }
  }

  suspend fun removeAdFromProfile(adId: UUID) {
    database.userAdsRelationDao().delete(adId)
  }

  suspend fun removeAd(adId: UUID) {
    database.adsDao().deleteAd(adId)
  }

  suspend fun addAd(
    adName: String,
    description: String,
    price: Int,
    category: String,
    email: String,
  ) {
    database.adsDao().insert(
      AdDataModel(
        email = email,
        name = adName,
        price = price,
        description = description,
        image = "",
        category = category,
      )
    )
  }

  suspend fun saveLoggedUser(
    email: String,
    logged: Boolean,
  ) {
    database.userDao().setUserLogged(email, logged)
  }

  fun getLoggedUserFlow(): Flow<UserDataModel?> {
    return database.userDao().getLoggedUserFlow()
  }

  suspend fun getLoggedUser(): UserDataModel? {
    return database.userDao().getLoggedUser()
  }
}
