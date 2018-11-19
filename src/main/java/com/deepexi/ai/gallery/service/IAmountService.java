package com.deepexi.ai.gallery.service;

import com.deepexi.ai.gallery.model.Amount;

import java.util.List;

public interface IAmountService {
    void addPlayCount();
    List<Amount> findAmount();

    void save(Amount amount);
}
