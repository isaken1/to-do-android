package com.example.to_dolistapp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Task implements Serializable {

    private String title;
    private String description;
    private Date initialDate;
    private Date finishDate;

    public Task (String titulo, String descricao){
        this.title = titulo;
        this.description = descricao;
        this.initialDate = new Date();
        this.finishDate = new Date();
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

    @Override
    public String toString() {
        return title;
    }
}
