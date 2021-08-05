package com.example.attendenceapp.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.attendenceapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class StudentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = inflater.inflate(R.layout.fragment_student,container,false)

        val addStudents = binding.findViewById<FloatingActionButton>(R.id.add_student_float_btn)
        addStudents.setOnClickListener {
            findNavController().navigate(R.id.action_studentFragment_to_addStudents)
        }

        return binding
    }


}