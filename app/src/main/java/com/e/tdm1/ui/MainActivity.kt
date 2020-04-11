package com.e.tdm1.ui

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView

import android.widget.ArrayAdapter

import androidx.recyclerview.widget.LinearLayoutManager
import com.e.tdm1.R

import com.e.tdm1.data.ToDoItem
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.to_do_list_fragment.to_do_list

class MainActivity : AppCompatActivity() , View.OnClickListener  ,
    ToDoListAdapter.OnNoteListner ,
    AdapterView.OnItemSelectedListener{

    private lateinit var todoList: ArrayList<ToDoItem>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createToDoList()


        if(isTablet(this)){

            var sppinerAdapet : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.nim, android.R.layout.simple_spinner_item)
            sppinerAdapet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            combobox.adapter = sppinerAdapet
            combobox.onItemSelectedListener = this
        }

        to_do_list.also {
            it.layoutManager = LinearLayoutManager(this as Context)
            it.setHasFixedSize(true)
            it.adapter = ToDoListAdapter(todoList , this , this)
        }

        add_btn.setOnClickListener (this)

    }



    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


    
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text : String  =parent!!.getItemAtPosition(position).toString()

    }

    private fun isTablet(context: Context):Boolean
    {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
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
