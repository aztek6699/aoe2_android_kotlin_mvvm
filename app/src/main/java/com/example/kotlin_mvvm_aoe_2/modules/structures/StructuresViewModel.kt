package com.example.kotlin_mvvm_aoe_2.modules.structures

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_mvvm_aoe_2.database.AppDatabase
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StructuresViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: StructuresRepo =
        StructuresRepo(AppDatabase.getDatabase(application).roomDao())

    init {
        viewModelScope.launch(Dispatchers.IO) { repo.getAllStructuresApi() }
    }

    fun getAllStructures(): LiveData<List<StructureDto>> {
        return repo.getAllStructures()
    }
}