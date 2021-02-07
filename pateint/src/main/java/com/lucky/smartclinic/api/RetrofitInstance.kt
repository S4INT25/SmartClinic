package com.lucky.smartclinic.api


import com.lucky.smartclinic.utils.NewsUtils.NEWS_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
  private  val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val newsApi: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}