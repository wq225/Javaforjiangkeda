package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    //列出商家的信息
    public void listAllBusinesses();
    //显示所有商家信息
    public void selectBusinesses();
    //保存商家信息
    public void saveBusiness();
    //删除商家信息
    public void removeBusiness();
    //商家登录
    public Business login();
    //显示商家信息
    public void showBusinessInfo(Integer businessId);
    //修改商家信息
    public void updateBusinessInfo(Integer businessId);
    //修改密码
    public void updatePassword(Integer businessId);
}
