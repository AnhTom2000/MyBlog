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
import java.util.Objects;

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
    public List<Tag> saveTags(String[] tags, Long userId) {
        //将传过来的新标签字符串解析为集合
        List<Tag> tagList = new ArrayList<>();
        //遍历集合保存标签
        for (String tag : tags) {
            Long snowId = SNOWFLAKE_ID_GENERATOR.generateId();
            dao.saveTag(tag, snowId, userId);
            tagList.add(TagUtils.getTag(tag, snowId));
        }
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
    public List<Tag> findByTagName(String[] tags, Long userId) {
        List<Tag> tag_List = new ArrayList<>();
        for (String tagName : tags) {
            tag_List.add(dao.findByTagName(tagName, userId));
        }
        return tag_List;
    }

    /**
     * @Method
     * Description:
     *  根据标签名称查询
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<Tag> searchTagByName(String tagName) {
        return dao.findTagByName(tagName);
    }

    @Override
    public List<Tag> findTagByUserId(Long userId) {
        return dao.findTagByUserId(userId);
    }


    @Override
    public List<Tag> getTagList(String[] newTag, String[] tags, Long userId) {
        List<Tag> tagList = null;
        // 如果旧标签数组不为空
        if (!Objects.isNull(tags)) {
            // 找不到这个旧表签
            tagList = findByTagName(tags, userId);
            if (tagList.contains(null)) {
                //当成新标签插入
                tagList = saveTags(tags, userId);
            }
            if (!Objects.isNull(newTag)) {
                // 插入新标签
                tagList.addAll(saveTags(newTag, userId));
            }
            //    否则直接插入新标签
        } else {
            if (!Objects.isNull(newTag)) {
                tagList = saveTags(newTag, userId);
            }
        }
        return tagList;
    }


}
