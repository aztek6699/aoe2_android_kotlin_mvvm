package com.example.kotlin_mvvm_aoe_2.modules.units

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient

class UnitsRepo(private val roomDao: RoomDao) {

    fun getAllUnits(): LiveData<List<UnitDto>> {
        return roomDao.getUnitsLiveData()
    }

    suspend fun getAllUnitsApi() {
        val response = RetrofitClient.instance.getAllUnitsApi()
        response.body()?.list?.let { roomDao.insertUnits(it) }
    }
}