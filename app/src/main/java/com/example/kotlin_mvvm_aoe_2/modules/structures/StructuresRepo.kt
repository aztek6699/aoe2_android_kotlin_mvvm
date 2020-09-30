package com.example.kotlin_mvvm_aoe_2.modules.structures

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient

class StructuresRepo(private val roomDao: RoomDao) {

    fun getAllStructures(): LiveData<List<StructureDto>> {
        return roomDao.getStructuresLiveData()
    }

    suspend fun getAllStructuresApi() {
        val response = RetrofitClient.instance.getAllStructuresApi()
        response.body()?.list?.let { roomDao.insertStructures(it) }
    }
}