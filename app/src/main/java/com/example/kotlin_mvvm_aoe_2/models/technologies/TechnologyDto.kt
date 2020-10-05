package com.example.kotlin_mvvm_aoe_2.models.technologies

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_mvvm_aoe_2.models.CostDto
import com.google.gson.annotations.SerializedName

@Entity(tableName = "technologies_table")
data class TechnologyDto(
    @PrimaryKey
    val id: Int,

    val name: String?,
    val description: String?,
    val expansion: String?,
    val age: String?,

    @Embedded
    val cost: CostDto?,

    @ColumnInfo(name = "develops_in")
    @SerializedName("develops_in")
    val developsIn: String?,

    @ColumnInfo(name = "build_time")
    @SerializedName("build_time")
    val buildTime: Int?,

    @ColumnInfo(name = "applies_to")
    @SerializedName("applies_to")
    val appliesTo: List<String>?
)