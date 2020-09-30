package com.example.kotlin_mvvm_aoe_2.modules.technologies

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient

class TechnologiesRepo(private val roomDao: RoomDao) {

    fun getAllTechnologies(): LiveData<List<TechnologyDto>> {
        return roomDao.getTechnologiesLiveData()
    }

    suspend fun getAllStructuresApi() {
        val response = RetrofitClient.instance.getAllTechnologiesApi()
        response.body()?.list?.let { roomDao.insertTechnologies(it) }
    }
}