package com.example.kotlin_mvvm_aoe_2.models.structures

import com.google.gson.annotations.SerializedName

data class AllStructuresResponseDto(
    @SerializedName("structures") val list: List<StructureDto>
)