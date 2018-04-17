package com.fans.farm.mapper;

import com.fans.farm.model.Product;
import com.fans.farm.model.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    long countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    @Insert({
        "insert into product (id, product_code, ",
        "name, original_price, ",
        "current_price, picture_url, ",
        "sale, discription, ",
        "type, create_date)",
        "values (#{id,jdbcType=INTEGER}, #{productCode,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{originalPrice,jdbcType=REAL}, ",
        "#{currentPrice,jdbcType=REAL}, #{pictureUrl,jdbcType=VARCHAR}, ",
        "#{sale,jdbcType=INTEGER}, #{discription,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, product_code, name, original_price, current_price, picture_url, sale, discription, ",
        "type, create_date",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.fans.farm.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated
     */
    @Update({
        "update product",
        "set product_code = #{productCode,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "original_price = #{originalPrice,jdbcType=REAL},",
          "current_price = #{currentPrice,jdbcType=REAL},",
          "picture_url = #{pictureUrl,jdbcType=VARCHAR},",
          "sale = #{sale,jdbcType=INTEGER},",
          "discription = #{discription,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}