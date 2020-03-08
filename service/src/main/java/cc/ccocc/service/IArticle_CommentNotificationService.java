package cc.ccocc.service;

import cc.ccocc.dto.CommentNotificationDTO;
import cc.ccocc.dto.ResultDTO;

import java.util.List;

/**
 * Created on 19:53  08/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IArticle_CommentNotificationService {
    // 添加点赞消息
    public Integer addArticle_CommentNotification(Long userId,Long authId,Long articleId,Long commentId,String type,String commentContent);

    public Integer addComment_ReplyNotification(Long userId, Long authId,Long articleId, Integer replyId, String type,String commentContent);

    public ResultDTO updateMarkReadStatus(Long authId);

    public ResultDTO deleteComment_ReplyAllNotice(Long authId);

    public List<CommentNotificationDTO> findComment_ReplyNotificationByUserId (Long authId);

    public Integer UnMarkReadCount(Long authId);

    public ResultDTO deleteComment_ReplyNotice(Long article_comment_Notification_id);
}
