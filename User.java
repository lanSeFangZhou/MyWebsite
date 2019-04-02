package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author yjli
 * @description
 * @date 2019/3/29
 */
@Document(collection = "demo_collection")
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private String password;

    private String role;

    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User(Long id, String name, String password, String role, String level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.level = level;
    }

    public User() {
    }
}

