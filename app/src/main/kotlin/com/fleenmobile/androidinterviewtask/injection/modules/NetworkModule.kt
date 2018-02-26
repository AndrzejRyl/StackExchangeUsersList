package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.BuildConfig
import com.fleenmobile.androidinterviewtask.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author FleenMobile at 2018-02-26
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Singleton
    @Provides
    fun okHttp(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @Singleton
    @Provides
    fun retrofit(httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    @Singleton
    @Provides
    fun apiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}