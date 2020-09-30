package com.example.kotlin_mvvm_aoe_2.modules.technologies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TechnologiesViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: TechnologiesRepo =
        TechnologiesRepo(AppDatabase.getDatabase(application).roomDao())

    init {
        viewModelScope.launch(Dispatchers.IO) { repo.getAllStructuresApi() }
    }

    fun getAllTechnologies(): LiveData<List<TechnologyDto>> {
        return repo.getAllTechnologies()
    }
}