package io.readian.uniapp.di.networking

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.readian.uniapp.di.qualifiers.ApiUrl
import io.readian.uniapp.di.qualifiers.Authenticated
import io.readian.uniapp.di.qualifiers.Unauthenticated
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Singleton
    @Unauthenticated
    fun unauthenticatedOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    @Authenticated
    fun authenticatedRetrofit(
      @ApiUrl baseUrl: String,
      @Authenticated client: OkHttpClient,
      converter: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(converter)
        .build()

    @Provides
    @Singleton
    @Unauthenticated
    fun unauthenticatedRetrofit(
      @ApiUrl baseUrl: String,
      @Unauthenticated client: OkHttpClient,
      converter: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(converter)
        .build()
}
