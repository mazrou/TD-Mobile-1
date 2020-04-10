package com.e.tdm1

import com.e.tdm1.data.ToDoListRepository
import org.junit.Assert
import org.junit.Test

class ToDoListRepositoryTest {

    private val toDoListRepository = ToDoListRepository()

    @Test
    fun addition_isCorrect() {

        val size = 40
        val todoList = toDoListRepository.generateToDoList(size)
        for (i in 1..size) {
            println(todoList[i-1].title)
        }
        Assert.assertEquals(todoList!!.size, size)
    }
}