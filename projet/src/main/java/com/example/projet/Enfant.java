package com.example.projet;

/**
 * Created by lombardr on 27/03/14.
 */
public class Enfant {
    private int id;
    private String prenom;
    private int age;

    public Enfant(){}

    public Enfant(String prenom, int age){
        this.prenom = prenom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
