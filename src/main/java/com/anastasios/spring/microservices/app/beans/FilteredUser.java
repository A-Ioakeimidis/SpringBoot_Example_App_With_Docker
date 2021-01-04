package com.anastasios.spring.microservices.app.beans;


import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("FilteredUserFilter")
public class FilteredUser {
    //Use @JsonIgnore to statically ignore fields.
    // @JsonFilter is used to filter dynamically.
    private String name;
    private int age;
    private String password;

    public FilteredUser(String name, int age, String password) {
        super();
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
