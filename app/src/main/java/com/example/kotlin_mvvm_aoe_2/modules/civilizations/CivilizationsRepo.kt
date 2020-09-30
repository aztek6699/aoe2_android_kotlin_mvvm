package com.example.kotlin_mvvm_aoe_2.modules.civilizations

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient

class CivilizationsRepo(private val roomDao: RoomDao) {

    fun getAllCivilizations(): LiveData<List<CivilizationDto>> {
        return roomDao.getCivilizationsLiveData()
    }

    suspend fun getAllCivilizationsApi() {
        val response = RetrofitClient.instance.getAllCivilizationsApi()
        response.body()?.list?.let { roomDao.insertCivilizations(it) }
    }
}