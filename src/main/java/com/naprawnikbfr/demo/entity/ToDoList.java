package com.naprawnikbfr.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//annotate class as an entity
@Entity
@Table(name = "lists")
public class ToDoList {

    //define the fields and annotate the fields with DB columns names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "list_id")
    private int listId;

    @Column (name = "list_name")
    private String listName;

    @OneToMany (mappedBy = "toDoList",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    //create constructors
    //non-arg - required by HIB/JPA
    public ToDoList() {}

    public ToDoList(String listName) {
        this.listName = listName;
    }

    //create getters and setters
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    //utility methods which are used to synchronize both sides of the bidirectional association
    public void addTask(Task tempTask){
        tasks.add(tempTask);
        tempTask.setToDoList(this);
    }

    //!!!! utility method for remove !!!!

    @Override
    public String toString() {
        return "List{" +
                "listId=" + listId +
                ", listName='" + listName + '\'' +
                '}';
    }
}
