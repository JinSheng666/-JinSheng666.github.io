package com.jinsheng.dao;

import org.apache.ibatis.annotations.*;
import com.jinsheng.domain.Brand;

import java.util.List;

public interface BrandDao {
    @Select("select * from tb_brand; ")
    List<Brand> selectAll();

    /*@ResultMap("brandResultMap")*/
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status});")
    void add(Brand brand);

    //批量删除
    void deleteByIds(@Param("ids") List<Integer> ids);

    //单个删除数据
    @Delete("delete from tb_brand where id = #{id};")
    void deleteById(@Param("id") int id);

    //记录总数
    @Select("select count(*) from tb_brand;")
    int selectTotalCount();

    //分页查询
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin ,@Param("size") int size);

    //分页和条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin , @Param("size") int size, @Param("brand") Brand brand);

    //根据条件查询记录总数
    int selectTotalCountByCondition(Brand brand);

    //回显数据，根据Id查询
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(@Param("id") Integer id);

    //修改产品信息
    @ResultMap("brandResultMap")
    @Update("update tb_brand set " +
            "brand_name = #{brandName}," +
            "company_name = #{companyName}," +
            "ordered = #{ordered}," +
            "description = #{description}," +
            "status = #{status} where id = #{id};")
    void update(Brand brand);

}
