package io.readian.uniapp.core.database

import androidx.room.TypeConverter
import io.readian.uniapp.core.database.model.UserType

class Converters {

  @TypeConverter
  fun userTypeToString(userType: UserType): String {
    return userType.name
  }

  @TypeConverter
  fun stringToUserType(userType: String): UserType {
    return UserType.valueOf(userType)
  }
}
