package com.e.tdm1.ui.ui.bookdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.tdm1.data.Book
import com.e.tdm1.repository.BookRepository

class BookDetailsViewModel(
    private val repository: BookRepository
) : ViewModel(
) {

    private lateinit var _book : MutableLiveData<Book>

    val book : LiveData<Book>
        get() =  _book


    fun getBook(){
        repository.getBook()
    }
}
