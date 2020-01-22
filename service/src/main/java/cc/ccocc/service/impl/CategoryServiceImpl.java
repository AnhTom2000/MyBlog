package cc.ccocc.service.impl;

import cc.ccocc.dao.ICategoryDao;
import cc.ccocc.pojo.Category;
import cc.ccocc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 09:10  19/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    @Qualifier("categorydao")
    private ICategoryDao dao;


    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findById(Integer categoryId) {
        return dao.findById(categoryId);
    }
}
