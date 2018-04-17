package com.fans.farm.service;

import com.fans.farm.model.Product;

import java.util.List;

/**
 * @author: Ike.Fan
 * @date: 2018/4/3.
 */
public interface ProductService {
    Boolean addProduct(Product product);
    Boolean deleteProduct(int productId);
    List<Product> getProductList(int pageNum, int pageSize);
}
