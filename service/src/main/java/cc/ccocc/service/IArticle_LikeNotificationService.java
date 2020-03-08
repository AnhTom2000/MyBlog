package cc.ccocc.service;

import cc.ccocc.dto.LikeNotificationDTO;
import cc.ccocc.dto.ResultDTO;

import java.util.List;

/**
 * Created on 20:57  07/02/2020
 * Description:
 *
 * @author Weleness
 */

public interface IArticle_LikeNotificationService {

    // 添加文章点赞消息
    public Integer addArticle_LikeNotification(Long userId,Long authId,Long articleId,String articleTitle,String type);
    // 添加评论点赞消息
    public Integer  addCommentLikeNotificaton(Long userId, Long authId, Long articleId,String articleTitle,String commentContent, String type);
    // 更新已读状态
    public ResultDTO updateMarkReadStatus(Long authId);
    // 删除所有点赞消息推送
    public ResultDTO deleteLikeAllNotice(Long authId);
    // 查找用户所有点赞消息推送
    public List<LikeNotificationDTO> findLikeNotificationByUserId (Long authId);
    // 统计未读消息数量
    public Integer UnMarkReadCount(Long authId);
    // 删除单个点赞消息推送
    public ResultDTO deleteLikeNotice(Long likeNotificationId);
}
