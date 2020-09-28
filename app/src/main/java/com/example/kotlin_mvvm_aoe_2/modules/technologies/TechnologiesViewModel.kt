package com.example.kotlin_mvvm_aoe_2.modules.technologies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto

class TechnologiesViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: TechnologiesRepo =
        TechnologiesRepo(AppDatabase.getDatabase(application).roomDao())

    fun getAllTechnologies(): LiveData<List<TechnologyDto>> {
        return repo.getAllTechnologies()
    }
}