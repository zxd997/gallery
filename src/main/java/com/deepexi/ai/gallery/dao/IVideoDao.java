package com.deepexi.ai.gallery.dao;

import com.deepexi.ai.gallery.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVideoDao  extends MongoRepository<Video,String> {
}
