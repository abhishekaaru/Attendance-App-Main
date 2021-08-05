package com.example.attendenceapp.addstudent

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.attendenceapp.R
import com.example.attendenceapp.studentdatabase.Students
import com.google.android.material.textfield.TextInputLayout

class AddStudents : Fragment() {


    private val addStudentViewModel:AddStudentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_add_students, container, false)



        //dropdown list
        val items = listOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView).setAdapter(adapter)


        //data adding
        val save_btn = binding.findViewById<Button>(R.id.save_btn)
        val student_name = binding.findViewById<EditText>(R.id.student_name)
        val Roll_no = binding.findViewById<EditText>(R.id.Roll_no)
        val Age = binding.findViewById<EditText>(R.id.Age)
        val gender_lable = binding.findViewById<TextInputLayout>(R.id.gender_lable)

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

        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //kharabi aa gyi hai
//        val model = ViewModelProvider(requireActivity()).get(AddStudentViewModel::)
    }
}