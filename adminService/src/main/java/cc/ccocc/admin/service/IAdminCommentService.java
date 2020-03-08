package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ReplyDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 14:59  26/01/2020
 * Description:
 * 评论的服务接口
 *
 * @author Weleness
 */

public interface IAdminCommentService {

    public Integer getAllCommentCount();

    public void  deleteByUser(Long userId);

    public void deleteByArticle(Long articleId);



    public List<Comment> findByArticleId(Long articleId);

    public AdminDTO<List<Comment>> findAll(Integer pageNo , Integer pageSize);

    public AdminDTO deleteComments(Long[] commentIds);

}
