package com.example.kotlin_mvvm_aoe_2.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlin_mvvm_aoe_2.models.civilizations.CivilizationDto
import com.example.kotlin_mvvm_aoe_2.models.structures.StructureDto
import com.example.kotlin_mvvm_aoe_2.models.technologies.TechnologyDto
import com.example.kotlin_mvvm_aoe_2.models.units.UnitDto

@Database(
    entities = [
        CivilizationDto::class,
        StructureDto::class,
        TechnologyDto::class,
        UnitDto::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomDao(): RoomDao

    companion object {

        private val TAG: String = AppDatabase::class.java.simpleName

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            synchronized(this) {

                INSTANCE?.apply {
                    Log.d(TAG, "room db instance present, no need to build instance")
                    return this
                }

                Log.d(TAG, "room db instance not present, building instance and returning")
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "room_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}