package com.example.attendenceapp.studentattendence

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeClassRight(var adapter: StudentAttendenceRecyclerView):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        val view = viewHolder.itemView
        adapter.updateAttendenceSwipeRight(pos,view)
    }
}

class SwipeClassLeft(var adapter: StudentAttendenceRecyclerView):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        val view = viewHolder.itemView
        adapter.updateAttendenceSwipeLeft(pos,view)
    }
}