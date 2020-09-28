package com.example.kotlin_mvvm_aoe_2.webservice

import com.example.kotlin_mvvm_aoe_2.models.civilizations.AllCivilizationsResponseDto
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import com.example.kotlin_mvvm_aoe_2.models.structures.AllStructuresResponseDto
import com.example.kotlin_mvvm_aoe_2.models.technologies.AllTechnologiesResponseDto
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import com.example.kotlin_mvvm_aoe_2.models.units.AllUnitsResponseDto
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("civilizations")
    suspend fun getAllCivilizationsApi(): Response<AllCivilizationsResponseDto>

    @GET("civilization/{name}")
    suspend fun getCivilizationByName(@Path("name") name: String): Response<CivilizationDto>

    @GET("units")
    suspend fun getAllUnitsApi(): Response<AllUnitsResponseDto>

    @GET("unit/{name}")
    suspend fun getUnitByName(@Path("name") name: String): Response<UnitDto>

    @GET("structures")
    suspend fun getAllStructuresApi(): Response<AllStructuresResponseDto>

    @GET("structure/{name}")
    suspend fun getStructureByName(@Path("name") name: String)

    @GET("technologies")
    suspend fun getAllTechnologiesApi(): Response<AllTechnologiesResponseDto>

    @GET("technology/{name}")
    suspend fun getTechnologyByNameApi(): Response<TechnologyDto>
}