package com.deepexi.ai.gallery.service.impl;

import com.deepexi.ai.gallery.dao.IAmountDao;
import com.deepexi.ai.gallery.model.Amount;
import com.deepexi.ai.gallery.service.IAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountService implements IAmountService {
    @Autowired
    IAmountDao amountDao;
    @Override
    public void addPlayCount() {

    }

    @Override
    public List<Amount> findAmount() {
        return amountDao.findAll();
    }

    @Override
    public void save(Amount amount) {
        amountDao.save(amount);
    }
}
