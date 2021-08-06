package com.example.attendenceapp.addstudent

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.fragment.app.activityViewModels
import com.example.attendenceapp.studentdatabase.Students
import android.view.*
import androidx.fragment.app.Fragment
import com.example.attendenceapp.R
import com.example.attendenceapp.databinding.FragmentAddStudentsBinding


class AddStudents : Fragment() {

    private val addStudentViewModel:AddStudentViewModel by activityViewModels()

    private var _binding: FragmentAddStudentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddStudentsBinding.inflate(inflater, container, false)

        // Dropdown List
        val items = listOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setAdapter(adapter)


        //data adding
        val save_btn = binding.saveBtn
        val student_name = binding.studentName
        val Roll_no = binding.RollNo
        val Age = binding.Age
        val gender_lable = binding.genderLable

        save_btn.setOnClickListener {

            val studentName = student_name.text.toString()
            val rollNo = Roll_no.text.toString().toInt()
            val age = Age.text.toString().toInt()
            val gender = gender_lable.editText.toString()

            if(studentName.isNotEmpty())
            {
                addStudentViewModel.insertStudentViewModel(Students(studentName,rollNo,age,gender))
                Log.d("save","datasaved")
                Toast.makeText(requireContext(), "inserted", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(requireContext(), "enter text", Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //kharabi aa gyi hai
        // val model = ViewModelProvider(requireActivity()).get(AddStudentViewModel::)
    }

}


