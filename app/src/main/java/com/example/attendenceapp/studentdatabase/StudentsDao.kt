package com.example.attendenceapp.studentdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentsDao {

    @Insert
    suspend fun insertStudent(data:Students)

    @Query(value = "DELETE FROM student_record")
    suspend fun deleteAllStudents()

    @Query(value = "SELECT * FROM student_record ORDER BY StudentName")
    fun getAllStudentData():LiveData<List<Students>>

}