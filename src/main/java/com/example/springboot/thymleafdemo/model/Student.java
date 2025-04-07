package com.example.springboot.thymleafdemo.model;

import com.example.springboot.thymleafdemo.validation.SuyanCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Student {
    @NotBlank(message = "First name is required")
    private String firstName;

    @SuyanCode(value="S", message="must start with S")
    @NotNull
    @Size(min = 2, message = "Last name must be at least 2 characters")
    private String lastName;

    private String country;
    private String favoriteLanguage;
    private List<String> favoriteSystem;

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public List<String> getFavoriteSystem() {
        return favoriteSystem;
    }

    public void setFavoriteSystem(List<String> favoriteSystem) {
        this.favoriteSystem = favoriteSystem;
    }

    public Student(String firstName, String lastName, String country, String favoriteLanguage, List<String> favoriteSystem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
        this.favoriteSystem = favoriteSystem;
    }


    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student() {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
