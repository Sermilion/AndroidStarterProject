package io.readian.uniapp.core.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserAdsDataModel(

  @Embedded
  val user: UserDataModel,

  @Relation(
    parentColumn = "email",
    entityColumn = "id",
    associateBy = Junction(UsersAdsRelationDataModel::class),
  )
  val ads: List<AdDataModel>
)