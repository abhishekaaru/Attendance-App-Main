package com.example.attendenceapp

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.attendenceapp.databinding.FragmentAddStudentsBinding
import com.example.attendenceapp.databinding.FragmentStudentBinding


class AddStudents : Fragment() {

    private var _binding: FragmentAddStudentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddStudentsBinding.inflate(inflater, container, false)

        val items = listOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setAdapter(adapter)

        return binding.root
    }


}