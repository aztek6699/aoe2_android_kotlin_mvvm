package com.example.kotlin_mvvm_aoe_2.models.units

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_mvvm_aoe_2.models.CostDto
import com.google.gson.annotations.SerializedName

@Entity(tableName = "units_table")
data class UnitDto(
    @PrimaryKey
    val id: String,

    val name: String?,
    val description: String?,
    val expansion: String?,
    val age: String?,
    val range: String?,
    val attack: Int?,
    val armor: String?,
    val accuracy: String?,

    @Embedded
    val cost: CostDto,

    @ColumnInfo(name = "created_in")
    @SerializedName("created_in")
    val createdIn: String?,

    @ColumnInfo(name = "build_time")
    @SerializedName("build_time")
    val buildTime: Int?,

    @ColumnInfo(name = "reload_time")
    @SerializedName("reload_time")
    val reloadTime: Double?,

    @ColumnInfo(name = "attack_delay")
    @SerializedName("attack_delay")
    val attackDelay: Double?,

    @ColumnInfo(name = "movement_rate")
    @SerializedName("movement_rate")
    val movementRate: Double?,

    @ColumnInfo(name = "line_of_sight")
    @SerializedName("line_of_sight")
    val lineOfSight: Int?,

    @ColumnInfo(name = "hit_points")
    @SerializedName("hit_points")
    val hitPoints: String?
)