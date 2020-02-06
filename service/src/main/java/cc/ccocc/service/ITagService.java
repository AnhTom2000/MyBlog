package cc.ccocc.service;

import cc.ccocc.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 16:37  16/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface ITagService {

    List<Tag> findByArticleId(Long article_id);

    Integer tag_Count();

    List<Tag> findAll();

   List<Tag>  saveTags(String[] newTag,Long userId);

    List<Tag> findByTagName(String[] tags,Long userId);

    List<Tag> findTagByUserId(Long userId);

    List<Tag> getTagList(String[] newTag,String[] tags , Long userId);
}
