package com.deepexi.ai.gallery.service.impl;

import com.deepexi.ai.gallery.dao.IVideoDao;
import com.deepexi.ai.gallery.model.Video;
import com.deepexi.ai.gallery.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    IVideoDao videoDao;
    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public void save(Video video) {
        videoDao.save(video);
    }

    @Override
    public Optional<Video> findById(String aId) {
        Optional<Video> opt = videoDao.findById(aId);
        return opt;
    }

    @Override
    public void deleteAll() {
        videoDao.deleteAll();
    }
}
