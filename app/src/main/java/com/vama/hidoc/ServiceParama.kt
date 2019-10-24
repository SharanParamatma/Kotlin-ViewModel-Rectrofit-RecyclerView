package com.vama.hidoc

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ServiceParama {

    @FormUrlEncoded
    @POST("healthtips.php")
    fun getFeed(@Field("userid") userid: String, @Field("lastcount") lastcount: Int): Call<Example>

    companion object {
        val Base_URl = "http://devapi.hidoc.co/healthtips/"
    }
}
