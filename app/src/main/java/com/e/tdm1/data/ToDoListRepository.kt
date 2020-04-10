package com.e.tdm1.data

const val STRING_LENGTH = 30

class ToDoListRepository {


    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9') + ' '

    fun generateToDoList(sizeOfTheList : Int = 10) : List<ToDoItem>{
         var toDoList = ArrayList<ToDoItem>()
         for ( i in  1..sizeOfTheList){
             val randomString = (1..STRING_LENGTH)
                 .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                 .map(charPool::get)
                 .joinToString("")

             val item = ToDoItem(randomString)

             toDoList.add(item)
         }
         return toDoList
     }

    fun getItems() : List<ToDoItem>{
        var toDoList = ArrayList<ToDoItem>()

        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        toDoList.add(ToDoItem("Finish tp"))
        return toDoList
    }
}