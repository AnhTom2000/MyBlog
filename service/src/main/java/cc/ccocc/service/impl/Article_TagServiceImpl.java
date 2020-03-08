package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_TagDao;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.IArticle_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 22:41  18/01/2020
 * Description:
 * 文章标签中间表服务实现类
 *
 * @author Weleness
 */
@Service("IArticle_TagService")
public class Article_TagServiceImpl implements IArticle_TagService {
    @Autowired
    @Qualifier("IArticle_TagDao")
    private IArticle_TagDao dao;

    /**
     * @param article 文章类，包含两个表的所有信息
     * @param tags    标签集合信息
     * @Method Description:
     * 文章标签中间表保存方法
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer saveInMiddle(Article article, List<Tag> tags) {
        Integer saveInMiddle = 0;
        if (!tags.contains(null)) {
            for (Tag tag : tags) {
                saveInMiddle += dao.saveInMiddle(article.getA_id(), tag.getTag_id());
            }
        }
        return saveInMiddle;
    }

    /**
     * @param tags    标签集合信息
     * @param article 文章信息
     * @Method Description:
     * 文章标签中间表修改方法
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer updateInMiddle(Article article, List<Tag> tags) {
        Integer updateInMiddle = 0;
        if (!tags.contains(null)) {
            System.out.println("修改");
            // 先将关于文章的标签的有关信息删除,再重新存储
            deleteInMiddle(article);
            for (Tag tag : tags) {
                updateInMiddle += dao.saveInMiddle(article.getA_id(), tag.getTag_id());
            }
        }
        return updateInMiddle;
    }

    /**
     * @param article 文章信息
     * @Method
     * Description:
     *  删除文章标签关系
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteInMiddle(Article article) {
        dao.deleteInMiddle(article.getA_id());
    }


}
