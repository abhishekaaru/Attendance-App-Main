package com.example.attendenceapp.studentdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Students::class],version = 1,exportSchema = false)
abstract class StudentsRoomDatabase: RoomDatabase() {

    abstract fun studentDao():StudentsDao

    companion object{

        @Volatile
        private var INSTANCE: StudentsRoomDatabase? = null

        fun getDatabase(context: Context): StudentsRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentsRoomDatabase::class.java,
                    "student_record"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }

        }

    }

}