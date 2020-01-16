package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticleDao;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 22:14  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("articleService")
public class ArtilceServiceImpl implements IArticleService {
    @Autowired
    private IArticleDao dao;


    @Override
    public List<Article> findAll() {
        return dao.findALL();
    }

    @Override
    public Integer article_Count() {
        return dao.article_Count();
    }

    @Override
    public List<Article> findArticleByTagId(Integer tag_id) {
        return dao.findArticleByTagId(tag_id);
    }

    @Override
    public List<Article> findArticleNew() {
        return dao.findArticleNew();
    }

    @Override
    public List<Article> findArticleOrderByYear() {
        return dao.findArticleOrderByYear();
    }
}
