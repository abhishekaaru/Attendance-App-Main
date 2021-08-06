package com.example.attendenceapp.studentdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_record")
class Students(_studentName:String,_rollNo:Int,_age:Int,_gender:String) {

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0

    @ColumnInfo(name = "StudentName")
    var studentName:String = _studentName

    @ColumnInfo(name = "RollNo")
    val rollNo:Int = _rollNo

    @ColumnInfo(name = "Age")
    val age:Int = _age

    @ColumnInfo(name = "Gender")
    val gender:String = _gender

}