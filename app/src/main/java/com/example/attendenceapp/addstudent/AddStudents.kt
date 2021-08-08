package com.example.attendenceapp.addstudent

import android.os.Bundle
import android.widget.*
import androidx.fragment.app.activityViewModels
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.attendenceapp.R
import com.example.attendenceapp.StudentApplication
import com.example.attendenceapp.StudentViewModel
import com.example.attendenceapp.StudentViewModelFactory
import com.example.attendenceapp.databinding.FragmentAddStudentsBinding


class AddStudents : Fragment() {

    private val addStudentViewModel: StudentViewModel by activityViewModels{
        StudentViewModelFactory(
            (activity?.application as StudentApplication).database.studentDao()
        )
    }


    private var _binding: FragmentAddStudentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddStudentsBinding.inflate(inflater, container, false)

        // Dropdown List
        val items = listOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setAdapter(adapter)

        return binding.root
    }


    // check if edit text are empty or not
    private fun isEntryValid(): Boolean {
        return addStudentViewModel.isEntryValid(
            binding.studentName.text.toString(),
            binding.RollNo.text.toString(),
            binding.Age.text.toString(),
            binding.genderLable.editText?.text.toString()
        )
    }

    private fun addNewStudent() {
        if (isEntryValid()) {
            addStudentViewModel.addNewItem(
                binding.studentName.text.toString(),
                binding.RollNo.text.toString(),
                binding.Age.text.toString(),
                binding.genderLable.editText?.text.toString()
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {
            addNewStudent()
            findNavController().navigate(R.id.action_addStudents_to_studentFragment)
        }
    }

}


