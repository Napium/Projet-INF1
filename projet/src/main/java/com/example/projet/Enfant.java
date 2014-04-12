package com.example.projet;

/**
 * Created by lombardr on 27/03/14.
 */
public class Enfant {
    private int id;
    private String prenom;
    private int age;
    private String image;

    public Enfant(){}

    public Enfant(String prenom, int age, String image){
        this.prenom = prenom;
        this.age = age;
        if( image != "null") {
            this.image = image;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
