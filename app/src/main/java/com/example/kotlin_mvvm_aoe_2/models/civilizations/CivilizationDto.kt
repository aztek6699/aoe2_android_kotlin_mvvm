package com.example.kotlin_mvvm_aoe_2.models.civilizations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "civilizations_table")
data class CivilizationDto(
    @PrimaryKey
    val id: Int,

    val name: String,
    val expansion: String,

    @ColumnInfo(name = "army_type")
    @SerializedName("army_type")
    val armyType: String,

    @ColumnInfo(name = "unique_unit")
    @SerializedName("unique_unit")
    val uniqueUnit: List<String>,

    @ColumnInfo(name = "unique_tech")
    @SerializedName("unique_tech")
    val uniqueTech: List<String>,

    @ColumnInfo(name = "team_bonus")
    @SerializedName("team_bonus")
    val teamBonus: String,

    @ColumnInfo(name = "civilization_bonus")
    @SerializedName("civilization_bonus")
    val civilizationBonus: List<String>
)