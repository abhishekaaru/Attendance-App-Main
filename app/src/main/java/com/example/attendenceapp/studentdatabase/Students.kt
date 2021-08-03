package com.example.attendenceapp.studentdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_record")
class Students(_studentName:String,_rollNo:Int,_age:Int,_gender:Boolean) {

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0

    @ColumnInfo(name = "StudentName")
    val studentName:String = _studentName

    @ColumnInfo(name = "RollNo")
    val rollNo:Int = _rollNo

    @ColumnInfo(name = "Age")
    val age:Int = _age

    @ColumnInfo(name = "Gender")
    val gender:Boolean = _gender

}