package com.example.to_dolistapp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Task implements Serializable {

    private String title;
    private String description;
    private Date initialDate;
    private Date finishDate;
    private boolean done;

    public Task(){
        this.initialDate = new Date();
    }

    public Task (String titulo, String descricao, Date finishDate){
        this.title = titulo;
        this.description = descricao;
        this.initialDate = new Date();
        this.finishDate = finishDate;
        done = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return title;
    }
}
