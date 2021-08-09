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

    val allStudentsList: LiveData<List<Students>> = studentDao.getAllStudentData()

    fun addNewItem(studentName: String, studentRollNo: String, studentAge: String,studentGender: String) {
        val newStudent = getNewStudentEntry(studentName,studentRollNo,studentAge,studentGender)
        insertStudentDataViewModel(newStudent)
    }

    private fun insertStudentDataViewModel(studentData: Students) = viewModelScope.launch{
        studentDao.insert(studentData)
    }

    private fun getNewStudentEntry(studentName: String, studentRollNo: String, studentAge: String, studentGender: String) : Students{
        return Students(
            studentName = studentName,
            rollNo = studentRollNo.toInt(),
            age = studentAge.toInt(),
            gender = studentGender
        )
    }

    // check if edit text are empty or not
    fun isEntryValid(studentName: String, studentRollNo: String, studentAge: String,studentGender: String): Boolean {
        if (studentName.isBlank() || studentRollNo.isBlank() || studentAge.isBlank() || studentGender.isBlank()) {
            return false
        }
        return true
    }

    fun deleteStudentDataViewModel() = viewModelScope.launch{
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