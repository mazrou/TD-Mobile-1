package com.e.tdm1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.tdm1.data.ToDoItem
import com.e.tdm1.data.ToDoListRepository
import kotlinx.coroutines.Job

class ToDoListViewModel(
    private val repository : ToDoListRepository
) : ViewModel() {


    private lateinit var job : Job

    private val _toDoList = MutableLiveData<List<ToDoItem>>()

     val toDoList : LiveData<List<ToDoItem>>
        get() =_toDoList


    fun deleteItem(index : Int){
        _toDoList.value!!.toMutableList().removeAt(index)
        ToDoList().notifyChange()
    }

    fun getItems()  {
        job = Coroutines.ioThMain(
            {repository.getItems()},
            {_toDoList.value = it}
        )
    }
    override fun onCleared() {
        if(::job.isInitialized){
            job.cancel()
        }
    }

}
