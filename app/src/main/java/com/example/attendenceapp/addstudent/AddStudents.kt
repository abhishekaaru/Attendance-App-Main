package com.example.attendenceapp.addstudent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.fragment.app.activityViewModels
import com.example.attendenceapp.studentdatabase.Students
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.attendenceapp.*
import com.example.attendenceapp.databinding.FragmentAddStudentsBinding


class AddStudents : Fragment() {

    /**
     * view model instance
     * Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
     * to share the ViewModel across fragments.
     */
    private val viewModel: StudentViewModel by activityViewModels {
        StudentViewModelFactory(
            (activity?.application as StudentApplication).database
                .studentDao()
        )
    }


    private var _binding: FragmentAddStudentsBinding? = null
    private val binding get() = _binding!!

//    private val navigationArgs: ItemDetailFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddStudentsBinding.inflate(inflater, container, false)

        // Dropdown List
        val items = listOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setAdapter(adapter)

        return binding.root
    }


    /**
     * submit button set on click listner for data save
     */
    private fun insertDataInDatabase(){

        /**
         * find view by binding
         */
        //val save_btn = binding.saveBtn
        val student_name = binding.studentName
        val Roll_no = binding.RollNo
        val Age = binding.Age
        val gender_lable = binding.genderLable

        val studentName = student_name.text.toString()
        val rollNo = Roll_no.text.toString().toInt()
        val age = Age.text.toString().toInt()
        val gender = gender_lable.editText.toString()

        if(studentName.isNotEmpty())
        {
            viewModel.insertStudentDataViewModel(Students(studentName,rollNo,age,gender))
            Log.d("save","datasaved")
            Toast.makeText(requireContext(), "inserted", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(requireContext(), "enter text", Toast.LENGTH_SHORT).show()


    }

    /**
     * Called when the view is created.
     * The itemId Navigation argument determines the edit item  or add new item.
     * If the itemId is positive, this method retrieves the information from the database and
     * allows the user to update it.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.saveBtn.setOnClickListener {
                insertDataInDatabase()
            }
    }


    /**
     * Called before fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        //kharabi aa gyi hai
//        // val model = ViewModelProvider(requireActivity()).get(AddStudentViewModel::)
//    }

}


