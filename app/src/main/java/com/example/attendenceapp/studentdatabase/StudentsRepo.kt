package com.example.attendenceapp.studentdatabase

import androidx.lifecycle.LiveData


class StudentsRepo(val _studentDao:StudentsDao) {

    val allStudents:LiveData<List<Students>>

    init {
        allStudents = _studentDao.getAllStudentData()
    }

    suspend fun insertStudentRepo(data:Students) {
        _studentDao.insertStudent(data)
    }

    suspend fun deleteAllStudents(){
        _studentDao.deleteAllStudents()
    }

}