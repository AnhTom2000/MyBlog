package cc.ccocc.service.impl;

import cc.ccocc.dao.ITagDao;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.ITagService;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.tag.TagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Override
    public List<Tag> findByArticleId(Long article_id) {
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

    /**
     * @param tags 新标签
     * @Method Description:
     * 保存新标签服务层方法
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<Tag> saveTags(String[] tags) {
        //将传过来的新标签字符串解析为集合
        List<Tag> tagList = new ArrayList<>();
        //遍历集合保存标签
        for (String tag : tags) {
            Long snowId = SNOWFLAKE_ID_GENERATOR.generateId();
            dao.saveTag(tag, snowId);
            tagList.add(TagUtils.getTag(tag, snowId));
        }
        System.out.println("fanhui"+tagList);
        return tagList;
    }

    /**
     * @param tags 标签名称字符串(在这里解析)
     * @Method Description:
     * 根据标签名称查找标签
     * @Author weleness
     * @Return
     */
    @Override
    public List<Tag> findByTagName(String[] tags) {
        List<Tag> tag_List = new ArrayList<>();
        for (String tagName : tags) {
            tag_List.add(dao.findByTagName(tagName));
        }
        return tag_List;
    }
}
