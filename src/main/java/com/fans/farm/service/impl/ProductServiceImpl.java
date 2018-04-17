package com.fans.farm.service.impl;

import com.fans.farm.mapper.ProductMapper;
import com.fans.farm.model.Product;
import com.fans.farm.service.ProductService;
import com.fans.farm.utils.CalendarUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ike.Fan
 * @date: 2018/4/3.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper mProductMapper;
    @Override
    public Boolean addProduct(Product product) {
        product.setCreateDate(CalendarUtil.getCalendar().getTime());
        return mProductMapper.insert(product)>0;
    }

    @Override
    public Boolean deleteProduct(int productId) {
        return mProductMapper.deleteByPrimaryKey(productId)>0;
    }

    @Override
    public List<Product> getProductList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mProductMapper.selectByExample(null);
    }
}
