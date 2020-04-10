package com.e.tdm1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.e.tdm1.R
import com.e.tdm1.data.ToDoItem
import com.e.tdm1.databinding.ToDoItemBinding


class ToDoListAdapter (
    private val todoList : List<ToDoItem>
   // val context : Context
): RecyclerView.Adapter<ToDoListAdapter.toDoListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoListAdapter.toDoListViewHolder
            = toDoListViewHolder(
        DataBindingUtil
        .inflate(
            LayoutInflater
            .from(parent.context),
            R.layout.to_do_item,
            parent,
            false
        ))


    override fun getItemCount() = todoList.size

    override fun onBindViewHolder(holder: toDoListViewHolder, position: Int) {
        holder.toDoRecyclerviewBinding.item = todoList[position]
    }


    inner class toDoListViewHolder (
        var toDoRecyclerviewBinding : ToDoItemBinding
    )  :
        RecyclerView.ViewHolder(toDoRecyclerviewBinding.root)


}