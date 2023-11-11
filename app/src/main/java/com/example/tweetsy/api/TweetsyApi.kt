package com.example.tweetsy.api

import com.example.tweetsy.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {


    @GET("/v3/b/654cfaa70574da7622c4414d?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String): Response<List<Tweet>>

    @GET("/v3/b/654cfaa70574da7622c4414d?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>
}