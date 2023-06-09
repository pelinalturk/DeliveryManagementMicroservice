package com.pelin.authenticationserver.dto;

public class UserDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;

    public UserDto(){}

    public UserDto(String firstname, String lastname, String email, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
