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

    List<Tag> findByArticleId(Integer article_id);

    Integer tag_Count();

    List<Tag> findAll();
}
