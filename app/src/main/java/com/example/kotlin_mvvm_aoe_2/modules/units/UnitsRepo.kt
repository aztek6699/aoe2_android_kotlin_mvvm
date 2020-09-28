package com.example.kotlin_mvvm_aoe_2.modules.units

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnitsRepo(private val roomDao: RoomDao) {
    init {
        getAllUnitsApi()
    }

    fun getAllUnits(): LiveData<List<UnitDto>> {
        return roomDao.getUnitsLiveData()
    }

    private fun getAllUnitsApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.instance.getAllUnitsApi()
            response.body()?.list?.let { roomDao.insertUnits(it) }
        }
    }
}