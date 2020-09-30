package com.example.kotlin_mvvm_aoe_2.modules.units

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnitsViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: UnitsRepo = UnitsRepo(AppDatabase.getDatabase(application).roomDao())

    init {
        viewModelScope.launch(Dispatchers.IO) { repo.getAllUnitsApi() }
    }

    fun getAllUnits(): LiveData<List<UnitDto>> {
        return repo.getAllUnits()
    }
}