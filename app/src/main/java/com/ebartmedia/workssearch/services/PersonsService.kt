package com.ebartmedia.workssearch.services

import android.arch.lifecycle.ViewModelProvider
//import com.ebartmedia.practicedrawerkt2.models.Words
import com.ebartmedia.workssearch.models.Persons
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PersonsService {

    @POST("/api/create")
    fun addPersons(@Body newPerson: Persons): Call<Persons>
}