package cc.ccocc.service;

import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ReplyDTO;
import cc.ccocc.dto.ResultDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 14:59  26/01/2020
 * Description:
 * 评论的服务接口
 *
 * @author Weleness
 */
@Repository
public interface ICommentService {

    public List<CommentDTO> findAllCommentByArticleId(Long articleId);

    public List<CommentDTO> insertArticleComment(String commentContent, Long articleId, Long userId, Long authId);

    public ReplyDTO insertArticle_Comment_Reply(String replyContent, Long articleId, Long parentId, Long userId, Long authId);

    public ResultDTO addCommentLike(Long commentId, Long userId, Long authId, Long articleId, String articleTitle, String commentContent);

    public Integer getAllCommentCount();

    public List<CommentDTO> getNewsComment(Long userId);

}
