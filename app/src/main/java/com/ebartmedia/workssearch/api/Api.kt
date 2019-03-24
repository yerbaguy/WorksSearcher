package com.ebartmedia.workssearch.api

import android.provider.ContactsContract
import com.ebartmedia.workssearch.models.AddPersonsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("addpersons")
    fun addword(
        @Field("username") username:String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<AddPersonsResponse>

    @FormUrlEncoded
    @POST("login")
    fun  login(
        @Field("username") username:String,
        @Field("password") password: String
    ): Call<AddPersonsResponse>
}