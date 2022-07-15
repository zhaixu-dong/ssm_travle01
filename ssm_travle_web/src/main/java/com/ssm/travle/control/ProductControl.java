package com.ssm.travle.control;

import com.github.pagehelper.PageInfo;
import com.ssm.travle.domain.Product;
import com.ssm.travle.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControl {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") int page,
                                @RequestParam(name = "pagesize",defaultValue = "1")int pagesize) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> productLis = productService.findAll(page,pagesize);
        PageInfo pageInfo = new PageInfo(productLis);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }
}
