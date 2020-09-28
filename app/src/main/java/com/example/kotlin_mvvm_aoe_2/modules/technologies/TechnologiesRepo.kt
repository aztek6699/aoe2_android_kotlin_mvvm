package com.example.kotlin_mvvm_aoe_2.modules.technologies

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TechnologiesRepo(private val roomDao: RoomDao) {
    init {
        getAllStructuresApi()
    }

    fun getAllTechnologies(): LiveData<List<TechnologyDto>> {
        return roomDao.getTechnologiesLiveData()
    }

    private fun getAllStructuresApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.instance.getAllTechnologiesApi()
            response.body()?.list?.let { roomDao.insertTechnologies(it) }
        }
    }
}