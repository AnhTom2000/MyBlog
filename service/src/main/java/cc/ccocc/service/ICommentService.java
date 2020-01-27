package cc.ccocc.service;

import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ReplyDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 14:59  26/01/2020
 * Description:
 *  评论的服务接口
 * @author Weleness
 */
@Repository
public interface ICommentService {

    public List<CommentDTO> findAllCommentByArticleId( Long articleId);

    public List<CommentDTO> insertArticleComment(String commentContent, String articleId, Long userId);

    public ReplyDTO insertArticle_Comment_Reply( String replyContent ,  String articleId,  String parentId,Long userId);

    public ResultDTO addCommentLike(String commentId,Long userId);
}
