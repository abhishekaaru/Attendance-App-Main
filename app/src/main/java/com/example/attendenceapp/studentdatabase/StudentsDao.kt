package com.example.attendenceapp.studentdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentsDao {

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(students: Students)

//    @Update
//    suspend fun update(students: Students)

//    @Delete
//    suspend fun delete(students: Students)

    @Query(value = "DELETE FROM student_record")
    suspend fun deleteAllStudents()

    @Query(value = "SELECT * FROM student_record ORDER BY StudentName")
    fun getAllStudentData():LiveData<List<Students>>

//
//    @Query("SELECT * from student_record WHERE id = :id")
//    fun getStudent(id: Int): Flow<Students>

}