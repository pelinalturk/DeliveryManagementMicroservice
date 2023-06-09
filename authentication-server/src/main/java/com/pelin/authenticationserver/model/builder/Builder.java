package com.pelin.authenticationserver.model.builder;

public interface Builder {
    Builder firstname(String firstname);
    Builder lastname(String lastname);
    Builder email(String email);
    Builder password(String password);
    Builder role(String role);
    Builder build();
}
