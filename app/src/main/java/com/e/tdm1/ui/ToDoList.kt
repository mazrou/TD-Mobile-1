package com.e.tdm1.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.e.tdm1.R
import kotlinx.android.synthetic.main.to_do_item.*
import kotlinx.android.synthetic.main.to_do_list_fragment.*

class ToDoList : Fragment() {

    companion object {
        fun newInstance() = ToDoList()
    }

    private lateinit var viewModel: ToDoListViewModel
    private lateinit var viewModelFactory: ToDoListViewModelFactory



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeUi()

        viewModel = ViewModelProviders.of(this).get(ToDoListViewModel::class.java)
     
    }


    private fun initializeUi(){

        viewModelFactory = Coroutines.provideToDoListViewModelFactory()
        viewModel=ViewModelProviders.of(this ,viewModelFactory ).get(ToDoListViewModel::class.java)

        viewModel.getItems()

        viewModel.toDoList.observe(viewLifecycleOwner, Observer {toDoList->
            to_do_list.also {

                it.layoutManager = LinearLayoutManager(activity)
                it.setHasFixedSize(true)
                it.adapter = ToDoListAdapter(toDoList)
            }

        })



    }



    fun notifyChange(){
        (to_do_list.adapter as ToDoListAdapter).notifyDataSetChanged()
    }

}
