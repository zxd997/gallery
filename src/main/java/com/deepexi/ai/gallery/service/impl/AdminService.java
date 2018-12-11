package com.deepexi.ai.gallery.service.impl;

import com.deepexi.ai.gallery.dao.IAdminDao;
//import com.deepexi.ai.gallery.dao.IAmountDao;
import com.deepexi.ai.gallery.model.Administrator;
//import com.deepexi.ai.gallery.model.Amount;
import com.deepexi.ai.gallery.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    IAdminDao adminDao;

    @Override
    public Administrator findOneByAdministratorName(String administratorName) {
        Administrator administrator=adminDao.findAdministratorByAdministratorName(administratorName);
        return administrator;
    }

    //    @Autowired
//    IAmountDao amountDao;
    @Override
    public Administrator findOneByName(String administratorName) {
        Administrator administrator=adminDao.findAdministratorByAdministratorName(administratorName);
        return administrator;
    }
//    @Override
//    public Amount find(){
//        return amountDao.find();
//    }
//    @Override
//    public void updateAmountByNum(int num){
//        amountDao.updateAmountByNum(num);
//    }
}
