package com.example.attendenceapp.addstudent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendenceapp.studentdatabase.Students
import com.example.attendenceapp.studentdatabase.StudentsRepo
import com.example.attendenceapp.studentdatabase.StudentsRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddStudentViewModel(application: Application) : AndroidViewModel(application) {

    private val allStudentsList:LiveData<List<Students>>
    private val studentRepo:StudentsRepo

    init {
        val studentDao = StudentsRoomDatabase.getDatabase(application).studentDao()
        studentRepo = StudentsRepo(studentDao)
        allStudentsList = studentRepo.allStudents
    }

    fun insertStudentViewModel(studentData:Students) = viewModelScope.launch(Dispatchers.IO){
        studentRepo.insertStudentRepo(studentData)
    }

}