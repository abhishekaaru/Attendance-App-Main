package com.example.attendenceapp.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.attendenceapp.R
import com.example.attendenceapp.StudentApplication
import com.example.attendenceapp.StudentViewModel
import com.example.attendenceapp.StudentViewModelFactory
import com.example.attendenceapp.databinding.FragmentStudentBinding


class StudentFragment : Fragment() {

    //instance of viewModel
    private val studentViewModel: StudentViewModel by activityViewModels{
        StudentViewModelFactory(
            (activity?.application as StudentApplication).database.studentDao()
        )
    }

    private var _binding: FragmentStudentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentStudentBinding.inflate(inflater,container,false)

        binding.addStudentFloatBtn.setOnClickListener {
            findNavController().navigate(R.id.action_studentFragment_to_addStudents)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //Creating Recycler View instance and bind it in mainactivity xml file recycler view
        binding.studentListRecyclerview.layoutManager = LinearLayoutManager(this.context)
        val adapter = StudentRecyclerViewAdapter()
        binding.studentListRecyclerview.adapter = adapter

        //observer when data change it send new list of data to adapter
        studentViewModel.allStudentsList.observe(this.viewLifecycleOwner, Observer { List ->
            List?.let {
                adapter.updateAllStudentData(it)
            }
        })

        //delete all button
        binding.deleteAllStudent.setOnClickListener {
            studentViewModel.deleteStudentDataViewModel()
        }

    }

}