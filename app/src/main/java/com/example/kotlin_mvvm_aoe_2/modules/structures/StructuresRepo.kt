package com.example.kotlin_mvvm_aoe_2.modules.structures

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StructuresRepo(private val roomDao: RoomDao) {

    init {
        getAllStructuresApi()
    }

    fun getAllStructures(): LiveData<List<StructureDto>> {
        return roomDao.getStructuresLiveData()
    }

    private fun getAllStructuresApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.instance.getAllStructuresApi()
            response.body()?.list?.let { roomDao.insertStructures(it) }
        }
    }
}