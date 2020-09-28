package com.example.kotlin_mvvm_aoe_2.models.structures

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_mvvm_aoe_2.models.CostDto
import com.google.gson.annotations.SerializedName

@Entity(tableName = "structures_table")
data class StructureDto(
    @PrimaryKey
    var id: Int,

    var name: String,
    var expansion: String,
    var age: String,
    var armor: String,

    var special: List<String>?,

    @Embedded
    var cost: CostDto,

    @ColumnInfo(name = "build_time")
    @SerializedName("build_time")
    var build_time: Int,

    @ColumnInfo(name = "hit_points")
    @SerializedName("hit_points")
    var hit_points: Int,

    @ColumnInfo(name = "line_of_sight")
    @SerializedName("line_of_sight")
    var line_of_sight: Int
)