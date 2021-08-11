package com.example.attendenceapp.studentdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.example.attendenceapp.studentdatabase.Students as Students1

@Dao
interface StudentsDao {

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(students: Students1)

    @Update
    suspend fun update(students: Students1)

    @Delete
    suspend fun delete(students: Students1)

    @Query(value = "DELETE FROM student_record")
    suspend fun deleteAllStudents()

    @Query(value = "SELECT * FROM student_record ORDER BY StudentName")
    fun getAllStudentData():LiveData<List<Students1>>

    @Query("SELECT * FROM student_record WHERE id = :id")
    fun getStudent(id: Int): LiveData<Students1>

}