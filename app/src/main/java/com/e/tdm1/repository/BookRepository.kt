package com.e.tdm1.repository

import com.e.tdm1.data.Book

class BookRepository (
    private var books :ArrayList<Book>
) {

    fun addBook( book : Book){
        books.add(book)
    }

    fun getAllBooks() : ArrayList<Book> {
        return books
    }


    fun getBook( index : Int)  : Book?{
        if(index >= books.size){
            return null
        }
        return books[index]
    }


}