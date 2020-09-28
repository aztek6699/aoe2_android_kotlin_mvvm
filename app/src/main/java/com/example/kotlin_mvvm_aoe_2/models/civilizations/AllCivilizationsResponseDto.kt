package com.example.kotlin_mvvm_aoe_2.models.civilizations

import com.google.gson.annotations.SerializedName

data class AllCivilizationsResponseDto(
    @SerializedName("civilizations") val list: List<CivilizationDto>
)