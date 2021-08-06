package com.example.attendenceapp

import android.app.Application
import com.example.attendenceapp.studentdatabase.StudentsRoomDatabase

class StudentApplication: Application(){
    // Using by lazy so the database is only created when needed
    // rather than when the application starts
    val database: StudentsRoomDatabase by lazy { StudentsRoomDatabase.getDatabase(this) }
}