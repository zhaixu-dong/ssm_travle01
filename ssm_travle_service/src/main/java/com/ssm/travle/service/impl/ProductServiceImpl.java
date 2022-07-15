package com.ssm.travle.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.travle.dao.IProductDao;
import com.ssm.travle.domain.Product;
import com.ssm.travle.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page,int pagesize) throws Exception {
        PageHelper.startPage(page,pagesize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
