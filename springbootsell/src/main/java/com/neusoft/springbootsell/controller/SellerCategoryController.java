package com.neusoft.springbootsell.controller;


import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.form.CategoryForm;
import com.neusoft.springbootsell.services.CategoryService;
import com.neusoft.springbootsell.services.ProductService;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    //新增类目
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false)Integer categoryId,
                              Map<String, Object> map) {
        if(categoryId!=null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    //保存商品类目
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if(form.getCategoryId()!=null){
                productCategory = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form,productCategory);
            categoryService.save(productCategory);
        } catch (Exception e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/category/index");
        return new ModelAndView("common/success",map);
    }

}