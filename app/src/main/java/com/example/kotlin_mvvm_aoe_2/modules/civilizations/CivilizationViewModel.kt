package com.example.kotlin_mvvm_aoe_2.modules.civilizations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CivilizationViewModel(application: Application) : AndroidViewModel(application) {

    private var repo: CivilizationsRepo =
        CivilizationsRepo(AppDatabase.getDatabase(application).roomDao())

    init {
        viewModelScope.launch(Dispatchers.IO) { repo.getAllCivilizationsApi() }
    }

    fun getAllCivilizations(): LiveData<List<CivilizationDto>> {
        return repo.getAllCivilizations()
    }
}