package com.lucky.smartclinic.repository

import com.lucky.smartclinic.api.RetrofitInstance
import com.lucky.smartclinic.model.News
import com.lucky.smartclinic.utils.NewsUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class SmartClinicRepository {

    fun getNews(): Flow<Response<News>>  =  flow{
        
            val newsResponse =  RetrofitInstance.newsApi.getNews(NewsUtils.options)
            emit(newsResponse)

    }.flowOn(Dispatchers.IO)


}