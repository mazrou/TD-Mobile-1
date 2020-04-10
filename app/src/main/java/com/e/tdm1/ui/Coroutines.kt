package com.e.tdm1.ui

import com.e.tdm1.data.ToDoListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun <T : Any > ioThMain( work: suspend(() -> T?) , callback: ((T?) -> Unit) ) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }

    fun provideToDoListViewModelFactory() : ToDoListViewModelFactory {
        val repository = ToDoListRepository()
        return ToDoListViewModelFactory(repository)
    }
}