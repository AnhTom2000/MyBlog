package cc.ccocc.dao;

import cc.ccocc.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 09:06  19/01/2020
 * Description:
 *  分类dao层mapper
 * @author Weleness
 */

@Repository("categorydao")
public interface ICategoryDao {

    /**
     * @Method
     * Description:
     *  查询所有分类
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT category_id , category_name FROM tb_category ")
    @Results(id = "category_map",value = {
            @Result(id = true,column = "category_id",property = "categoryid",javaType = Integer.class),
            @Result(column = "category_name",property = "categoryname",javaType = String.class)
    })
    List<Category> findAll();


    @ResultMap("category_map")
    @Select("SELECT category_id,category_name FROM tb_category WHERE category_id = #{categoryId}")
    Category findById(@Param("categoryId") Integer categoryId);
}
