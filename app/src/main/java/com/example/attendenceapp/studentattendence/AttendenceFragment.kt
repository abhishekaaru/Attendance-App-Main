package com.example.attendenceapp.studentattendence

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.attendenceapp.StudentApplication
import com.example.attendenceapp.StudentViewModel
import com.example.attendenceapp.StudentViewModelFactory
import com.example.attendenceapp.databinding.FragmentAttendenceBinding
import com.example.attendenceapp.studentdatabase.Students

class AttendenceFragment : Fragment() {

    private val viewModel: StudentViewModel by activityViewModels{
        StudentViewModelFactory(
            (activity?.application as StudentApplication).database.studentDao()
        )
    }

    private var _binding: FragmentAttendenceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentAttendenceBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Creating Recycler View instance and bind it in MainActivity xml file recycler view
        binding.studentFragmentListRecyclerview.layoutManager = LinearLayoutManager(this.context)
        val adapter = StudentAttendenceRecyclerView()
        binding.studentFragmentListRecyclerview.adapter = adapter

        viewModel.allStudentsList.observe(this.viewLifecycleOwner,Observer{ List ->
            List?.let {
                adapter.updateAllStudentData(it)
            }
        })

    }
}