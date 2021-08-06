package com.example.attendenceapp.addstudent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddStudentsViewModelFactory(private val application: Application) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddStudentsViewModelFactory(application) as T
    }
}