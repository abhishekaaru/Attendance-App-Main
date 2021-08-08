package com.example.attendenceapp.studentlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendenceapp.R
import com.example.attendenceapp.studentdatabase.Students


class StudentRecyclerViewAdapter:RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentDataVH>() {


    private val allStudentsData = ArrayList<Students>()

    inner class StudentDataVH(itemView: View): RecyclerView.ViewHolder(itemView){

        val studentName: TextView = itemView.findViewById(R.id.studentName_onList)
        val studentRollNo:TextView = itemView.findViewById(R.id.studentRoll_onList)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentDataVH {
        val viewHolder = StudentDataVH(LayoutInflater.from(parent.context).inflate(R.layout.adapter_student_list,parent,false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: StudentDataVH, position: Int) {

        val positionOnScreen = allStudentsData[position]
        holder.studentName.text = positionOnScreen.studentName
        holder.studentRollNo.text = positionOnScreen.rollNo.toString()
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