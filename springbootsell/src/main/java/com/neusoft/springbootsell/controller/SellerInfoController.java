package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.SellerInfo;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.form.SellerForm;
import com.neusoft.springbootsell.services.SellerService;
import com.neusoft.springbootsell.utils.KeyUtil;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * 用户登录控制
 * */
@Controller
@RequestMapping("/seller")
public class SellerInfoController {
    @Autowired
    private SellerService sellerService;

    //定义一个登录界面
    @GetMapping("/loginPage")
    public ModelAndView loginPage()
    {
        return new ModelAndView("seller/login");
    }

    //登录
    @PostMapping("/login")
    public ModelAndView login(@Valid SellerForm form,
                              BindingResult bindingResult,
                              Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map("msg",bindingResult.getFieldError().getDefaultMessage());
            map("url","seller/product/list");
        }
        SellerInfo sellerInfo=new SellerInfo();

        try{
            if (sellerInfo!=null){
                sellerInfo=sellerService.findSellerInfoByUsernameAndPassword(form.getUsername(),form.getPassword());
            }
            BeanUtils.copyProperties(form,sellerInfo);
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","product/list");
        return new ModelAndView("common/success",map);
    }

    //注册
    @GetMapping("/register")
    public ModelAndView register(@Valid SellerForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("mag",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/seller/register");
            return new ModelAndView("common/error",map);
        }

        SellerInfo sellerInfo=new SellerInfo();
        try {
            if (!StringUtils.isEmpty(form.getId())){
                sellerInfo=sellerService.findSellerInfoByUsernameAndPassword(form.getUsername(),form.getPassword());
            }else{
                form.setId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,sellerInfo);
            sellerService.save(sellerInfo);
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","seller/register");
            return new ModelAndView("common/error");
        }
        map.put("url","seller/register");
        return new ModelAndView("common/success",map);
    }




}
