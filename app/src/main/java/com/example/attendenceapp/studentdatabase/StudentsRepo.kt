package com.example.attendenceapp.studentdatabase

import androidx.lifecycle.LiveData


class StudentsRepo(private val _studentDao:StudentsDao) {

    val allStudents:LiveData<List<Students>> = _studentDao.getAllStudentData()

    suspend fun insertStudentRepo(data:Students) {
        _studentDao.insertStudent(data)
    }

    suspend fun deleteAllStudents(){
        _studentDao.deleteAllStudents()
    }

}