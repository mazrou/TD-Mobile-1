package com.e.tdm1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.tdm1.data.ToDoListRepository


class ToDoListViewModelFactory (
    private val repository: ToDoListRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoListViewModel(repository) as T
    }
}