package com.example.myapplication;

public class Songs {
    int id;
    String name;
    String author;
    int year;
    int duration;

    public Songs(int id, String name, String author, int year, int duration) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
