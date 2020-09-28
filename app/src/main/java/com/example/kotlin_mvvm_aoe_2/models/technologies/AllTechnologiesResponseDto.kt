package com.example.kotlin_mvvm_aoe_2.models.technologies

import com.google.gson.annotations.SerializedName

data class AllTechnologiesResponseDto(
    @SerializedName("technologies") val list: List<TechnologyDto>
)