package com.zalesskyi.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class NetModule {

    @Singleton
    @Provides
    fun provideGson(): Gson =
            GsonBuilder()
                    .create()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .callTimeout(20, TimeUnit.SECONDS)
                    .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,
                        gson: Gson,
                        factory: CallAdapter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl("")  // todo
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(factory)
                .client(okHttpClient)
                .build()
    }
}