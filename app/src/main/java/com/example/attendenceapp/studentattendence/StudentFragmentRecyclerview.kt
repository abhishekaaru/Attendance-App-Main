package com.example.attendenceapp.studentattendence

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendenceapp.R
import com.example.attendenceapp.studentdatabase.Students

class StudentAttendenceRecyclerView:RecyclerView.Adapter<StudentAttendenceRecyclerView.StudentAttendenceVH>(){

    private val allStudentsData = ArrayList<Students>()

    inner class StudentAttendenceVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val studentName_onList = itemView.findViewById<TextView>(R.id.studentName_onList)
        val studentRoll_onList = itemView.findViewById<TextView>(R.id.studentRoll_onList)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAttendenceVH {
        val viewHolder = StudentAttendenceVH(LayoutInflater.from(parent.context).inflate(R.layout.adapter_student_list,parent,false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: StudentAttendenceVH, position: Int) {
        val positionInList = allStudentsData[position]
        holder.studentName_onList.text = positionInList.studentName
        holder.studentRoll_onList.text = positionInList.rollNo.toString()
    }

    override fun getItemCount(): Int {
        return allStudentsData.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAllStudentData(itemList:List<Students>){

        allStudentsData.clear()
        allStudentsData.addAll(itemList)

        notifyDataSetChanged()
    }

}