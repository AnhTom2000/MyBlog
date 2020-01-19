package cc.ccocc.service;

import cc.ccocc.pojo.Category;

import java.util.List;

/**
 * Created on 09:09  19/01/2020
 * Description:
 *  分类服务层接口
 * @author Weleness
 */

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Integer categoryId);
}
