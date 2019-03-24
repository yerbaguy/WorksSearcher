package com.ebartmedia.workssearch.services

import com.ebartmedia.workssearch.models.PersonsLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PersonsLoginService {

    @POST("/api/toLogin")
    fun toLogin(@Body personsLogin: PersonsLogin): Call<PersonsLogin>
}
