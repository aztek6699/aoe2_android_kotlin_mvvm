package com.example.kotlin_mvvm_aoe_2.modules.civilizations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto

class CivilizationViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: CivilizationsRepo =
        CivilizationsRepo(AppDatabase.getDatabase(application).roomDao())

    fun getAllCivilizations(): LiveData<List<CivilizationDto>> {
        return repo.getAllCivilizations()
    }
}