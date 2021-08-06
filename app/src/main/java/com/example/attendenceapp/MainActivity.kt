package com.example.attendenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.attendenceapp.addstudent.AddStudentViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel:AddStudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}