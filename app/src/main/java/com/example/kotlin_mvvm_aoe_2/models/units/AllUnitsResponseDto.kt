package com.example.kotlin_mvvm_aoe_2.models.units

import com.google.gson.annotations.SerializedName

data class AllUnitsResponseDto(
    @SerializedName("units") val list: List<UnitDto>
)