package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.SellerInfo;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户登录控制
 * */
@Controller
@RequestMapping("/seller/log")
public class SellerInfoController {
    @Autowired
    private SellerService sellerService;

    //定义一个登录界面
    @GetMapping("/loginPage")
    public ModelAndView loginPage()
    {
        return new ModelAndView("seller/login");
    }

//    //登录功能
//    @PostMapping("/login")
//    public ModelAndView Login(@RequestParam("username")String username,
//                              @RequestParam("password")String password){
//        List<SellerInfo> sellerInfos=sellerService.findByUsernameAndPassword(username,password);
//        for (SellerInfo l:sellerService.findAll()){
//            System.out.println(l.getUsername()+":"+l.getPassword());
//        }
//        System.out.println(username+":"+password);
//
//        SellerInfo sellerInfo=new SellerInfo();
//        if (sellerInfos.equals(sellerInfo.getUsername())&&sellerInfos.equals(sellerInfo.getPassword())){
//            return new ModelAndView("product/list");
//        }else{
//            return new ModelAndView("common/error");
//        }
//    }

//    //登录2.0
//    @PostMapping("/login")
//    public ModelAndView login (@RequestParam("username")String username,
//                         @RequestParam("password")String password,
//                         Map<String,Object> map){
//       SellerInfo sellerInfo=sellerService.findSellerInfoByUsernameAndPassword(username, password);
//       if (sellerInfo==null){
//           map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
//           map.put("url","/seller/product/list");
//           return new ModelAndView("common/error");
//       }else{
//           map.put("msg", ResultEnum.LOGOUT_SUCCESS);
//           map.put("url","/seller/product/list");
//       }
//       return new ModelAndView("product/list");
//    }

    //登录3.0
    @PostMapping("/login")
    public ModelAndView login (@RequestParam("username")String username,
                               @RequestParam("password")String password,
                               Map<String,Object> map) {
        try {
            SellerInfo sellerInfo = sellerService.findSellerInfoByUsernameAndPassword(username, password);
        } catch (Exception e) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error");
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS);
        map.put("url", "/seller/product/list");

        return new ModelAndView("common/success", map);
    }
}
