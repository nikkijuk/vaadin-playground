package com.example.vaadin8binder;

/**
 * Simple login bean
 *
 * When user logs in username and email are alternative ways to identity user,
 * password should be always given to authenticate access.
 */
public class Login {

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
