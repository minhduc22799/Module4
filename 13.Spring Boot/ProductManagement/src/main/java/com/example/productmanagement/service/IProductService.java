package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{
    List<Product> findProductContaining(String name);
}
