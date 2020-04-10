package com.e.tdm1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.e.tdm1.R
import com.e.tdm1.data.ToDoItem

import kotlinx.android.synthetic.main.to_do_item.view.*


class ToDoListAdapter (
    private val todoList : List<ToDoItem> ,
    private  val onNoteListner : OnNoteListner,
    val context : Context
): RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.to_do_item, parent, false) , onNoteListner)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.item.text = todoList[position].title
    }


    class ViewHolder (view: View ,
                      private  val onNoteListner : OnNoteListner
    ) : RecyclerView.ViewHolder(view)  ,
        View.OnClickListener{

        init {
            view.setOnClickListener(this)
        }
        val item = view.to_do_item

        override fun onClick(v: View?) {
            onNoteListner.onNoteLister(adapterPosition)
        }
    }

    interface OnNoteListner{
        fun onNoteLister(position : Int)
    }
}