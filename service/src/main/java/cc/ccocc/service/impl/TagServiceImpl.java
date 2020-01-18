package cc.ccocc.service.impl;

import cc.ccocc.dao.ITagDao;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 16:37  16/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("tagService")
public class TagServiceImpl implements ITagService {
    @Autowired
    private ITagDao dao;

    @Override
    public List<Tag> findByArticleId(Integer article_id) {
        return dao.findByArticleId(article_id);
    }

    @Override
    public Integer tag_Count() {
        return dao.tag_Count();
    }

    @Override
    public List<Tag> findAll() {
        return dao.findAll();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
    @Override
    public void save(List<Tag> tags) {
        for (Tag tag : tags) {
            dao.saveTag(tag);
        }
    }
}
