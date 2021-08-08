package com.example.attendenceapp.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendenceapp.R
import com.example.attendenceapp.studentdatabase.Students


class StudentRecyclerViewAdapter:RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentDataVH>() {


    val allStudentsData = ArrayList<Students>()

    inner class StudentDataVH(itemView: View): RecyclerView.ViewHolder(itemView){

        val studentName = itemView.findViewById<TextView>(R.id.studentName_onList)
        val studentRollNo = itemView.findViewById<TextView>(R.id.studentRoll_onList)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentDataVH {
        val viewHolder = StudentDataVH(LayoutInflater.from(parent.context).inflate(R.layout.adapter_student_list,parent,false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: StudentDataVH, position: Int) {

        val Position = allStudentsData[position]
        holder.studentName.text = Position.studentName
        holder.studentRollNo.text = Position.rollNo.toString()
    }

    override fun getItemCount(): Int {
        return allStudentsData.size
    }

    fun updateAllStudentData(itemList:List<Students>){

        allStudentsData.clear()
        allStudentsData.addAll(itemList)

        notifyDataSetChanged()
    }

}