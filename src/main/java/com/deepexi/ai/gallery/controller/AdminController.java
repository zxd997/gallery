package com.deepexi.ai.gallery.controller;

import com.deepexi.ai.gallery.dao.IAdminDao;
import com.deepexi.ai.gallery.model.Administrator;
import com.deepexi.ai.gallery.model.Response;
import com.deepexi.ai.gallery.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    IAdminService adminService;
    @Autowired
    IAdminDao adminDao;

    @RequestMapping("/33")
    public String add(){
        Administrator adm1 = new Administrator("xiaoming", "123");
        Administrator adm2 = new Administrator("xiaoli", "456");
        adminDao.save(adm1);
        adminDao.save(adm2);
        return "lalala";
    }
    @RequestMapping("/login")
    public Response login(String administratorName,String password){
        Administrator administrator=adminService.findOneByName(administratorName);
        Response response = new Response();
        if (administrator != null) {
            String admPassword = administrator.getPassword();
            if (admPassword.equals(password)) {
                //登陆成功
                response.setCode(200);
                response.setMsg("登录成功！");
                httpSession.setAttribute("administrator",administrator);
            } else {
                response.setCode(500);
                response.setMsg("密码错误！");
            }
        } else {
            response.setCode(500);
            response.setMsg("用户名不正确");
        }
        return response;
    }
}
