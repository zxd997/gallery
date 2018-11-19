package com.deepexi.ai.gallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Video {
    @Id
    private String id;
    private String title;
    private String url;
    private String content;
    private String fileCoverUrl;

    public Video() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileCoverUrl() {
        return fileCoverUrl;
    }

    public void setFileCoverUrl(String fileCoverUrl) {
        this.fileCoverUrl = fileCoverUrl;
    }
}
