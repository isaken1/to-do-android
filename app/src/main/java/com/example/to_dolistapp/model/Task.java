package com.example.to_dolistapp.model;

import java.io.Serializable;
import java.util.Calendar;

public class Task implements Serializable {

    private String title;
    private String description;
    private Calendar initialDate;
    private Calendar finishDate;

    public Task (String titulo, String descricao){
        this.title = titulo;
        this.description = descricao;
        this.initialDate = Calendar.getInstance();
        this.initialDate.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
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

    public Calendar getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return title;
    }
}
