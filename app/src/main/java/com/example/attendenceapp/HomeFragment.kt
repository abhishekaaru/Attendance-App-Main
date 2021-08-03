package com.example.attendenceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_home,container,false)

        val attendence_button = binding.findViewById<Button>(R.id.attendence_button)

        attendence_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_attendenceFragment)
        }

        val add_student_button = binding.findViewById<Button>(R.id.add_student_button)

        add_student_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_studentFragment)
        }

        return binding

    }

}