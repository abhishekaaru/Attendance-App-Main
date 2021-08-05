package com.example.attendenceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.attendenceapp.databinding.FragmentHomeBinding
import com.example.attendenceapp.databinding.FragmentStudentBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.attendenceButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_attendenceFragment)
        }

        binding.addStudentButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_studentFragment)
        }

        return binding.root

    }

}