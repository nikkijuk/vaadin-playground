package com.example.vaadin8binder;

import java.math.BigDecimal;

/**
 * Simple login bean
 *
 * When user logs in username and email are alternative ways to identity user,
 * password should be always given to authenticate access.
 *
 * Secret is added as just text fields without converter doesn't seem to trigger bug I try to discover.
 */
public class Login {

    private String username;
    private String email;
    private String password;
    private BigDecimal secret = BigDecimal.ZERO;
    private Boolean register = Boolean.TRUE;

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

    public BigDecimal getSecret() {
        return secret;
    }

    public void setSecret(BigDecimal secret) {
        this.secret = secret;
    }

    public Boolean getRegister() {
        return register;
    }

    public void setRegister(Boolean register) {
        this.register = register;
    }
}
