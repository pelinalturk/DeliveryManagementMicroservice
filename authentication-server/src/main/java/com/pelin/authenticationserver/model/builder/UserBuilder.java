package com.pelin.authenticationserver.model.builder;

import com.pelin.authenticationserver.model.Role;
import com.pelin.authenticationserver.model.User;

public class UserBuilder {
    private String firstname;
    private String lastname;
    private String email;
    private String passwd;
    private Role role;

    public UserBuilder firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserBuilder lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(String password) {
        this.passwd = password;
        return this;
    }

    public UserBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        return new User(firstname, lastname, email, passwd, role);
    }
}

