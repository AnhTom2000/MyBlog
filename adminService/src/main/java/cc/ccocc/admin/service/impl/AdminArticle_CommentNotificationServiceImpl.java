package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminArticle_CommentNotificationService;
import cc.ccocc.dao.IArticle_Comment_NotificationDao;
import cc.ccocc.dto.CommentNotificationDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.CommentNotification;
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
@Service("adminArticle_commentNotice")
public class AdminArticle_CommentNotificationServiceImpl implements IAdminArticle_CommentNotificationService {

    @Autowired
    private IArticle_Comment_NotificationDao article_comment_notificationDao;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();


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

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        article_comment_notificationDao.delteCommentNoticeByUser(userId);
    }


}
