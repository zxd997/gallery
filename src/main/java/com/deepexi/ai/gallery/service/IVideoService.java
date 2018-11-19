package com.deepexi.ai.gallery.service;

import com.deepexi.ai.gallery.model.Video;

import java.util.List;
import java.util.Optional;

public interface IVideoService {
    List<Video> findAll();

    void save(Video video);

    Optional<Video> findById(String aId);

    void deleteAll();
}
