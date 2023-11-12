package io.readian.uniapp.core.domain.model

import io.readian.uniapp.core.database.model.AdDataModel
import io.readian.uniapp.core.database.model.UserDataModel
import io.readian.uniapp.core.database.model.UserType

object AdsMapper {

  fun List<AdDataModel>.mapToUiModel(user: UserDataModel): List<Ad> {
    return this.map { ad ->
      Ad(
        name = ad.name,
        price = ad.price.toString(),
        description = ad.description,
        image = ad.image,
        category = ad.category,
        selected = ad.email == user.email && user.type == UserType.Company,
        id = ad.id,
      )
    }
  }
}