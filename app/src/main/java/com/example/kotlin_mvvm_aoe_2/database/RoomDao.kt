package com.example.kotlin_mvvm_aoe_2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCivilizations(list: List<CivilizationDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStructures(list: List<StructureDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTechnologies(list: List<TechnologyDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnits(list: List<UnitDto>)

    @Query("select * from civilizations_table order by id asc")
    fun getCivilizationsLiveData(): LiveData<List<CivilizationDto>>

    @Query("select * from structures_table order by id asc")
    fun getStructuresLiveData(): LiveData<List<StructureDto>>

    @Query("select * from technologies_table order by id asc")
    fun getTechnologiesLiveData(): LiveData<List<TechnologyDto>>

    @Query("select * from units_table order by id asc")
    fun getUnitsLiveData(): LiveData<List<UnitDto>>
}