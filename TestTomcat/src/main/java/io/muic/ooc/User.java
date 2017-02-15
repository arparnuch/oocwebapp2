package io.muic.ooc;

import javax.servlet.http.Cookie;

/**
 * Created by arparnuch on 2/13/2017 AD.
 */
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    boolean authen = false;
    private Cookie cookie;

    public User(String username, String password, Cookie cookie){
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }



    public User(String username, String password, Cookie cookie, String firstname,String lastname, String email){
        this.username = username;
        this.password = password;
        this.cookie = cookie;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }


    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isAuthen() {
        return authen;
    }

    public void setAuthen(boolean authen) {
        this.authen = authen;
    }
}

