package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminArticle_LikeNotificationService;
import cc.ccocc.dao.IArticle_LikeNotificationDao;
import cc.ccocc.dto.LikeNotificationDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.LikeNotification;
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
public class AdminArticle_LikeNotificationServiceImpl implements IAdminArticle_LikeNotificationService {

    @Autowired
    private IArticle_LikeNotificationDao likeNotificationDao;

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

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        likeNotificationDao.deleteLikeNotice(userId);
    }


}
