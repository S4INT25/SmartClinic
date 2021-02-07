package com.lucky.smartclinic.utils

object NewsUtils {
    private const val query = "health"
    internal const val NEWS_BASE_URL = "https://newsapi.org"
    internal const val NEWS_END_POINT = "/v2/top-headlines"
    internal val options =  mapOf("q" to query,"pageSize" to "15","sortBy" to "relevancy", "language" to "en", "apiKey" to "efe58e9768be4765ba6d0b37a8ff0ce9")
}