package com.example.dormeaseuser.network

import com.example.dormeaseuser.ui.home.Complaints
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("complaints")
    fun getComplaint(): Call<List<Complaints>>
}
