package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_Comment_NotificationDao;
import cc.ccocc.dto.CommentNotificationDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.CommentNotification;
import cc.ccocc.service.IArticle_CommentNotificationService;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 19:57  08/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("article_commentNotice")
public class Article_CommentNotificationServiceImpl implements IArticle_CommentNotificationService {

    @Autowired
    private IArticle_Comment_NotificationDao article_comment_notificationDao;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @param authId    被评论的用户id
     * @param userId    评论的用户id
     * @param commentId 评论的id
     * @param type      评论类型
     * @param articleId  评论的文章id
     * @param commentContent  评论内容
     * @Method Description:
     * <p>添加文章评论消息</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addArticle_CommentNotification(Long userId,Long authId,Long articleId,Long commentId,String type,String commentContent) {
        CommentNotification commentNotification = CommentNotification.builder().
                article_comment_Notification_id(ID_GENERATOR.generateId()).
                userId(userId).authId(authId).articleId(articleId).commentId(commentId).
                commentContent(commentContent).
                createTime(LocalDateTime.now(Clock.systemDefaultZone())).
                markRead(false).type(type).build();

        return article_comment_notificationDao.addArticle_CommentNotification(commentNotification);
    }

    /**
     * @param articleId 文章id
     * @param commentContent 回复内容
     * @param authId 被回复的用户id
     * @param type 消息类型
     * @param userId 回复的用户
     * @param replyId 回复id
     * @Method Description:
     * <p>添加评论回复消息</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addComment_ReplyNotification(Long userId, Long authId,Long articleId, Integer replyId, String type,String commentContent) {
        CommentNotification commentNotification = CommentNotification.builder().
                article_comment_Notification_id(ID_GENERATOR.generateId()).
                userId(userId).authId(authId).articleId(articleId).
                createTime(LocalDateTime.now(Clock.systemDefaultZone())).
                markRead(false).replyId(replyId).
                commentContent(commentContent).type(type).build();

        return article_comment_notificationDao.addComment_replyNotification(commentNotification);
    }

    /**
     * @Method Description:
     * 更新未读状态
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO updateMarkReadStatus(Long authId) {
        return (article_comment_notificationDao.updateMarkReadStatus(authId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "标记成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @Method Description:
     * 删除全部的消息推送
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteComment_ReplyAllNotice(Long authId) {
        return (article_comment_notificationDao.deleteAllCommemtNotice(authId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "删除成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @Method Description:
     * 查找用户的所有消息推送
     * @Author weleness
     * @Return
     */
    @Override
    public List<CommentNotificationDTO> findComment_ReplyNotificationByUserId(Long authId) {
        List<CommentNotification> noticeList = null;
        List<CommentNotificationDTO> notificationDTOList = new ArrayList<>();
        ;
        if ((noticeList = article_comment_notificationDao.findNoticeByUserId(authId)) != null) {
            BeanCopier beanCopier = BeanCopier.create(CommentNotification.class, CommentNotificationDTO.class, false);
            for (CommentNotification notices : noticeList) {
                CommentNotificationDTO notificationDTO = new CommentNotificationDTO();
                beanCopier.copy(notices, notificationDTO, null);
                notificationDTOList.add(notificationDTO);
            }
        }
        return notificationDTOList;
    }

    /**
     * @Method Description:
     * 统计未读消息数量
     * @Author weleness
     * @Return
     */
    @Override
    public Integer UnMarkReadCount(Long authId) {
        return article_comment_notificationDao.UnMarkReadCount(authId);
    }

    /**
     * @Method Description:
     * 删除单个消息推送
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteComment_ReplyNotice(Long article_comment_Notification_id) {
        return (article_comment_notificationDao.deleteCommentNoticeOne(article_comment_Notification_id) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(),"删除成功",true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(),"服务器异常",false);
    }
}
