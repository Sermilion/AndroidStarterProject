package io.readian.uniapp.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.readian.uniapp.core.database.UniAppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
  @Provides
  @Singleton
  fun providesNiaDatabase(
    @ApplicationContext context: Context,
  ): UniAppDatabase = Room.databaseBuilder(
    context,
    UniAppDatabase::class.java,
    "uniapp-database",
  ).build()
}