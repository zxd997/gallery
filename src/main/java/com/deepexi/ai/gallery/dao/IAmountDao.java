package com.deepexi.ai.gallery.dao;

import com.deepexi.ai.gallery.model.Amount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAmountDao extends MongoRepository<Amount,String> {
}
