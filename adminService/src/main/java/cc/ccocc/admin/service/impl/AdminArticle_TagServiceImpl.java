package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminArticle_TagService;
import cc.ccocc.dao.IArticle_TagDao;
import cc.ccocc.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 22:41  18/01/2020
 * Description:
 * 文章标签中间表服务实现类
 *
 * @author Weleness
 */
@Service("admin Article_TagService")
public class AdminArticle_TagServiceImpl implements IAdminArticle_TagService {
    @Autowired
    @Qualifier("IArticle_TagDao")
    private IArticle_TagDao dao;


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

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteInMiddleByUser(Long articleId) {
        dao.deleteInMiddle(articleId);
    }


}
