package com.example.attendenceapp.addstudent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.attendenceapp.R
import com.example.attendenceapp.StudentApplication
import com.example.attendenceapp.StudentViewModel
import com.example.attendenceapp.StudentViewModelFactory
import com.example.attendenceapp.databinding.FragmentStudentDetailBinding
import com.example.attendenceapp.studentdatabase.Students
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class StudentDetail : Fragment() {

    private val navigationArgs: StudentDetailArgs by navArgs()

    private val viewModel: StudentViewModel by activityViewModels{
        StudentViewModelFactory(
            (activity?.application as StudentApplication).database.studentDao()
        )
    }

    lateinit var student: Students

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = navigationArgs.studentId
        viewModel.retrieveStudent(id).observe(this.viewLifecycleOwner) { selectedStudent ->
            student = selectedStudent
            bind(student)
        }
    }

    private fun bind(student: Students){
        binding.apply {
            studentNameDetail.text = student.studentName
            rollInputDetail.text = student.rollNo.toString()
            ageInputDetail.text = student.age.toString()
            genderInputDetail.text = student.gender

            DeleteDetail.setOnClickListener { showConfirmationDialog() }
            editStudent.setOnClickListener { editStudent() }
        }
    }

    private fun deleteSingleStudent(){
        viewModel.deleteSingleStudent(student)
        findNavController().navigateUp()
    }

    private fun editStudent(){
        val action = StudentDetailDirections.actionStudentDetailToAddStudents("Edit Student", student.id)
        this.findNavController().navigate(action)
    }

    private fun showConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(android.R.string.dialog_alert_title))
            .setMessage(getString(R.string.delete_question))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.no)) { _, _ -> }
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                deleteSingleStudent()
            }
            .show()
    }


}