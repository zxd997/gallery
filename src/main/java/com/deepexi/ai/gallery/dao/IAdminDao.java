package com.deepexi.ai.gallery.dao;

import com.deepexi.ai.gallery.model.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAdminDao extends MongoRepository<Administrator,String> {
    Administrator findAdministratorByAdministratorName(String administratorName);
}
