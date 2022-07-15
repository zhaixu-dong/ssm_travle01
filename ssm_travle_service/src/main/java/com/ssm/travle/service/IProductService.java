package com.ssm.travle.service;

import com.ssm.travle.domain.Product;

import java.util.List;

public interface IProductService {
    public abstract List<Product> findAll(int page,int pagesize) throws Exception;

    public abstract void save(Product product) throws Exception;
}
