package com.naprawnikbfr.demo.entity;

import jakarta.persistence.*;

//annotate class as an entity
@Entity
@Table(name = "tasks")
public class Task {

    //define the fields and annotate the fields with DB columns names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "task_id")
    private int taskId;

    //    In case bi-directional:
    //    @ManyToOne (cascade = { CascadeType.PERSIST,
    //                            CascadeType.MERGE,
    //                            CascadeType.DETACH,
    //                            CascadeType.REFRESH,})
    //    @JoinColumn (name = "list_id")
    @Column (name = "list_id")
    private ToDoList toDoList;

    @Column (name = "task_description")
    private String taskDescription;

    @Column (name = "is_completed")
    private boolean isCompleted;

    //create constructors
    public Task(){}

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    //create getters and setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
