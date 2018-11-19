package com.deepexi.ai.gallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Amount {
    @Id
    private String id;
    private int num;

    public Amount(int num) {
        this.id= UUID.randomUUID().toString();
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
