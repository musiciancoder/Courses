package com.example.courses.model;

public class JwtUser { //for code flow protocol purposes only
    private String userName;
    private long id ;
    private String role;

    //User properties were all set to constant values, so that there is no username, id or role JSON requests on the body
    
    public void setUserName() { 
        this.userName = "userName";
    }

    public void setId() {
        this.id = (long) (10*Math.random());
    }

    public void setRole() {
        this.role = "role";
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
