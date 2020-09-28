package com.example.kotlin_mvvm_aoe_2.modules.civilizations

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.RoomDao
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import com.example.kotlin_mvvm_aoe_2.webservice.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CivilizationsRepo(private val roomDao: RoomDao) {

    init {
        getAllCivilizationsApi()
    }

    fun getAllCivilizations(): LiveData<List<CivilizationDto>> {
        return roomDao.getCivilizationsLiveData()
    }

    private fun getAllCivilizationsApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.instance.getAllCivilizationsApi()
            response.body()?.list?.let { roomDao.insertCivilizations(it) }
        }
    }
}