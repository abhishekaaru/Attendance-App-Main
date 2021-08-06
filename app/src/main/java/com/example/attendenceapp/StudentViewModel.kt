package com.example.attendenceapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.attendenceapp.studentdatabase.Students
import com.example.attendenceapp.studentdatabase.StudentsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(private val studentDao: StudentsDao) : ViewModel() {

    private val allStudentsList: LiveData<List<Students>> = studentDao.getAllStudentData()

    fun insertStudentDataViewModel(studentData: Students) = viewModelScope.launch(Dispatchers.IO){
        studentDao.insertStudent(studentData)
    }

    fun deleteStudentDataViewModel() = viewModelScope.launch(Dispatchers.IO){
        studentDao.deleteAllStudents()
    }

}

class StudentViewModelFactory(private val studentDao: StudentsDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}