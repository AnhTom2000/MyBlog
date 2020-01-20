package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_TagDao;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.IArticle_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created on 22:41  18/01/2020
 * Description:
 *  文章标签中间表服务实现类
 * @author Weleness
 */
@Service("IArticle_TagService")
public class Article_TagServiceImpl implements IArticle_TagService {
    @Autowired
    @Qualifier("IArticle_TagDao")
    private IArticle_TagDao dao;

    /**
     * @Method
     * Description:
     *
     * @Author weleness
     *
     * @Return
     * @param article 文章类，包含两个表的所有信息
     */
    @Override
    public void saveInMiddle(Article article,List<Tag> tags) {
        for (Tag tag : tags) {
            System.out.println(article.getA_id());
            System.out.println(tag);
            dao.saveInMiddle(article.getA_id(),tag.getTag_id());
        }
    }
}
