package com.example.expirycheck.retrofit

import com.example.expirycheck.barcode.BarcodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @GET("{barcode}?fields=brands,product_name,code,image_thumb_url")
    suspend fun getProduct(@Path("barcode") barcode: String): Response<BarcodeResponse>

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/auth/register")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}