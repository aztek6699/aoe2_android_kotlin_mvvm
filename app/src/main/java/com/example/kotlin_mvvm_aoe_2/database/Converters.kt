package com.example.kotlin_mvvm_aoe_2.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun stringListToString(list: List<String>?): String {

        val gson = Gson()

        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToStringList(string: String): List<String>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(string, listType)
    }
}