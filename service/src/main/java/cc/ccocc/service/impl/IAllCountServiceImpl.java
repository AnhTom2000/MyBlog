package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_CommentDao;
import cc.ccocc.pojo.Counts;
import cc.ccocc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created on 14:57  28/01/2020
 * Description:
 *  所有信息统计
 * @author Weleness
 */
@Service("allCountService")
public class IAllCountServiceImpl implements IAllCountService {

    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;

    @Autowired
    @Qualifier("tagService")
    private ITagService tagService;

    @Autowired
    @Qualifier("commentService")
    private ICommentService commentService;

    @Override
    public Counts getAllCount() {
        return Counts.builder().article_Count(articleService.article_Count()).tag_Count(tagService.tag_Count()).comment_Count(commentService.getAllCommentCount()).build();
    }
}
