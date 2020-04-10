package com.e.tdm1.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.webkit.RenderProcessGoneDetail
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.tdm1.R
import com.e.tdm1.data.ToDoItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.to_do_item.*
import kotlinx.android.synthetic.main.to_do_list_fragment.*
import kotlinx.android.synthetic.main.to_do_list_fragment.to_do_list

class MainActivity : AppCompatActivity() , View.OnClickListener  ,
    ToDoListAdapter.OnNoteListner {

    private lateinit var todoList: ArrayList<ToDoItem>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createToDoList()
        to_do_list.also {
            it.layoutManager = LinearLayoutManager(this as Context)
            it.setHasFixedSize(true)
            it.adapter = ToDoListAdapter(todoList , this , this)
        }







        add_btn.setOnClickListener (this)

    }



    override fun onClick(v: View?) {
        when( v!!.id){
            R.id.add_btn -> {
                if(add_text.text !=null){
                    val item : String? =add_text.text.toString()
                    todoList.add(ToDoItem((item!!)))
                    to_do_list.adapter!!.notifyDataSetChanged()
                }
            }
            R.id.check_image ->{

            }
        }
    }







    private fun createToDoList(){
        todoList = ArrayList()
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))
        todoList.add(ToDoItem("home work"))

    }



    override fun onNoteLister(position: Int) {
       todoList.removeAt(position)
        to_do_list.adapter!!.notifyDataSetChanged()

    }


}
