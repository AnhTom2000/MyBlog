package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_LikeNotificationDao;
import cc.ccocc.dto.LikeNotificationDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.LikeNotification;
import cc.ccocc.service.IArticle_LikeNotificationService;
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
 * Created on 21:04  07/02/2020
 * Description:
 * 点赞消息推送服务
 *
 * @author Weleness
 */
@Service("article_likeNotice")
public class Article_LikeNotificationServiceImpl implements IArticle_LikeNotificationService {

    @Autowired
    private IArticle_LikeNotificationDao likeNotificationDao;


    // 全局唯一的id生成器
    private static final IdGenerator NOTICE_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @param userId       用户id
     * @param articleId    文章id
     * @param type         消息类型
     * @param authId       被点赞的用户id
     * @param articleTitle 被点赞的文章
     * @Method Description:
     * <p>添加文章点赞消息</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addArticle_LikeNotification(Long userId, Long authId, Long articleId, String articleTitle, String type) {
        LikeNotification notice = LikeNotification.builder().likeNotificationId(NOTICE_GENERATOR.generateId())
                .articleId(articleId).userId(userId).authId(authId)
                .articleTitle(articleTitle).type(type)
                .createTime(LocalDateTime.now(Clock.systemDefaultZone()))
                .markRead(false).build();
        return likeNotificationDao.addArticle_LikeNotification(notice);
    }

    /**
     * @Method Description:
     * 添加评论点赞消息
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addCommentLikeNotificaton(Long userId, Long authId, Long articleId, String articleTitle, String commentContent, String type) {
        LikeNotification notice = LikeNotification.builder().likeNotificationId(NOTICE_GENERATOR.generateId()).userId(userId).authId(authId).articleId(articleId).articleTitle(articleTitle).commentContent(commentContent).type(type).createTime(LocalDateTime.now(Clock.systemDefaultZone())).markRead(false).build();
        return likeNotificationDao.addComment_LikeNotification(notice);
    }

    /**
     * @param authId 被点赞用户的id
     * @Method Description:
     * 更新是否已读
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO updateMarkReadStatus(Long authId) {
        return (likeNotificationDao.updateMarkReadStatus(authId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "标记成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @param authId 被点赞的用户id
     * @Method Description:
     * 删除消息推送
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteLikeAllNotice(Long authId) {
        return (likeNotificationDao.deleteLikeNotice(authId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "删除全部消息成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @param likeNotificationId 消息推送id
     * @Method Description:
     * 删除单个消息推送
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteLikeNotice(Long likeNotificationId) {
        return (likeNotificationDao.deleteLikeNoticeOne(likeNotificationId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "删除消息成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @param authId 用户id
     * @Method Description:
     * 查找用户的点赞消息推送
     * @Author weleness
     * @Return
     */
    @Override
    public List<LikeNotificationDTO> findLikeNotificationByUserId(Long authId) {
        List<LikeNotification> noticeList = null;
        List<LikeNotificationDTO> notificationDTOList = new ArrayList<>();
        ;
        if ((noticeList = likeNotificationDao.findNoticeByUserId(authId)) != null) {
            BeanCopier beanCopier = BeanCopier.create(LikeNotification.class, LikeNotificationDTO.class, false);
            for (LikeNotification notices : noticeList) {
                LikeNotificationDTO notificationDTO = new LikeNotificationDTO();
                beanCopier.copy(notices, notificationDTO, null);
                notificationDTOList.add(notificationDTO);
            }
        }
        return notificationDTOList;
    }

    /**
     * @param authId 用户id
     * @Method Description:
     * 用户的未读点赞消息数量
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer UnMarkReadCount(Long authId) {
        return likeNotificationDao.UnMarkReadCount(authId);
    }


}
