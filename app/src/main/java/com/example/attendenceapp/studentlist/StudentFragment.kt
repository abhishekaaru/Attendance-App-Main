package com.example.attendenceapp.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.attendenceapp.R
import com.example.attendenceapp.databinding.FragmentStudentBinding


class StudentFragment : Fragment() {

    private var _binding: FragmentStudentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentStudentBinding.inflate(inflater,container,false)

        binding.addStudentFloatBtn.setOnClickListener {
            findNavController().navigate(R.id.action_studentFragment_to_addStudents)
        }

        return binding.root
    }

}