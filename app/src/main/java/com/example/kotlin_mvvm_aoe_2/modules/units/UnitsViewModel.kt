package com.example.kotlin_mvvm_aoe_2.modules.units

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto

class UnitsViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: UnitsRepo = UnitsRepo(AppDatabase.getDatabase(application).roomDao())

    fun getAllUnits(): LiveData<List<UnitDto>> {
        return repo.getAllUnits()
    }
}