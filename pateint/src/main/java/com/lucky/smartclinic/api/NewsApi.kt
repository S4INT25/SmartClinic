package com.lucky.smartclinic.api
import com.lucky.smartclinic.model.News
import com.lucky.smartclinic.utils.NewsUtils.NEWS_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsApi {
    @GET(NEWS_END_POINT)
   suspend fun getNews(@QueryMap options: Map<String,String>):Response<News>
}