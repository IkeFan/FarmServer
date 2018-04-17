package com.fans.farm.controller;
import com.fans.farm.Global;
import com.fans.farm.common.ErrorCode;
import com.fans.farm.model.Product;
import com.fans.farm.net.RestResult;
import com.fans.farm.net.RestResultGenerator;
import com.fans.farm.service.ProductService;
import com.fans.farm.utils.EmptyChecker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author: Ike.Fan
 * @date: 2018/4/3.
 */
@Api("产品管理接口")
@RestController
@RequestMapping(Global.API_URL_PRODUCT)
public class ProductController {
    @Autowired
    ProductService mProductService;

    @ApiOperation(value = "添加新的产品",notes = "产品名称不能为空")
    @PostMapping("/add")
    public RestResult<Boolean> addProduct(@RequestBody Product product){
        if(EmptyChecker.isEmpty(product.getName())){
          return   RestResultGenerator.genErrorResult(ErrorCode.PRODUCT_NAME_NULL.getCode(),ErrorCode.PRODUCT_NAME_NULL.getMessage());
        }
        try{
            mProductService.addProduct(product);
            return RestResultGenerator.genSuccessResult();
        }catch (Exception e){
           return RestResultGenerator.genErrorResult(ErrorCode.EXCEPTION_ERR.getCode(),e.getMessage());
        }
    }

    @ApiOperation(value = "删除产品",notes = "产品Id不能为空")
    @DeleteMapping("/delete/{productId}")
    public RestResult<Boolean> deleteProduct(@PathVariable("productId") int productId){
        mProductService.deleteProduct(productId);
        return RestResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "分页获取产品列表", notes = "pageNum为第几页和pageSize每页多少条")
    @GetMapping("/list")
    public RestResult<List<Product>> getProductList(@RequestParam(name = "pageNum") int pageNum , @RequestParam(name = "pageSize") int pageSize){
        return  RestResultGenerator.genSuccessResult(mProductService.getProductList(pageNum,pageSize));
    }
}
