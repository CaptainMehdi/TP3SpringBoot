package com.example.tp3.forms;

import java.time.format.DateTimeFormatter;

public class ClientForm {
    private static DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String dateOfBirth;
    private boolean active;

    public ClientForm(String id, String firstName, String lastName, String email, int age, String dateOfBirth, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
    }
}
