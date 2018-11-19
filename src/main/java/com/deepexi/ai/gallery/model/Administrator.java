package com.deepexi.ai.gallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Administrator {
    @Id
    private String id;
    private String administratorName;
    private String password;

    public Administrator(String administratorName, String password) {
        this.id = UUID.randomUUID().toString();
        this.administratorName = administratorName;
        this.password = password;
    }

    public Administrator() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
