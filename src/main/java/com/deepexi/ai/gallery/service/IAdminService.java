package com.deepexi.ai.gallery.service;

import com.deepexi.ai.gallery.model.Administrator;
//import com.deepexi.ai.gallery.model.Amount;

public interface IAdminService {
    Administrator findOneByAdministratorName(String administratorName);

    //    @Autowired
    //    IAmountDao amountDao;
    Administrator findOneByName(String administratorName);
    //Amount find();

    //void updateAmountByNum(int num);
}
