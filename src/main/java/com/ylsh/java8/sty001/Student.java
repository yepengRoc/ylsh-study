package com.ylsh.java8.sty001;

public class Student {

    private String name;

    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public static int cmpByScore(Student s1,Student s2){
        return s1.getScore() - s2.getScore();
    }
}
