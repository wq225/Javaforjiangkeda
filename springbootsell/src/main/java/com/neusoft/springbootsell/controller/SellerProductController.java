package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.form.ProductForm;
import com.neusoft.springbootsell.services.CategoryService;
import com.neusoft.springbootsell.services.ProductService;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家商品控制
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    //查询商品列表
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5")Integer size,
                             Map<String, Object> map){

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currrentPage",page);
        map.put("size",size);
        return new  ModelAndView("product/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map){
        if(!StringUtils.isEmpty(productId)){
            // 修改
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        // 查询类目并且进行返回
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index");
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult, Map<String, Object> map
    ){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(form.getProductId())){
                productInfo = productService.findOne(form.getProductId()); // 有ProductId  修改
            }else {
                form.setProductId(KeyUtil.genUniqueKey());// 新增  生成一个id
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);
        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    //商品上架
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId, Map<String, Object> map) {
        try {
            ProductInfo productInfo = productService.onSale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error");
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    //商品下架
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId, Map<String, Object> map) {
        try {
            ProductInfo productInfo = productService.offSale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error");
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }

}