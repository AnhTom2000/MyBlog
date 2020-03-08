package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminSystemNotificationService;
import cc.ccocc.dao.ISystemNotificationDao;
import cc.ccocc.pojo.SystemNotification;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;


/**
 * Created on 22:39  09/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminSystemNotice")
public class AdminSystemNotificationImpl implements IAdminSystemNotificationService {

    @Autowired
    private ISystemNotificationDao systemNotificationDao;

    private static final IdGenerator SYSTEMIC_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @param userId  用户id
     * @param type    消息类型
     * @param messageContent  消息内容
     * @param messageTitle  消息标题
     * @param sourceId  消息来源id
     * @Method
     * Description:
     *  <p>给用户发送系统消息</p>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer addSystemNotice(Long userId, Long sourceId, String type, String messageContent, String messageTitle) {
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
        SystemNotification systemNotification = SystemNotification.builder().
                systemNotificationId(SYSTEMIC_GENERATOR.generateId()).
                userId(userId).sourceId(sourceId).type(type).
                messageContent(messageContent).createTime(now).markRead(false).messageTitle(messageTitle).build();

        return systemNotificationDao.addSystemNotificationToUser(systemNotification);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer addSysteNoticeBad(Long userId, String type,  String messageContent,String messageTitle) {
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
    SystemNotification systemNotification = SystemNotification.builder().
                systemNotificationId(SYSTEMIC_GENERATOR.generateId()).
                userId(userId).type(type).
                messageContent(messageContent).messageTitle(messageTitle).createTime(now).markRead(false).build();;
                return systemNotificationDao.addBadSystemNotificationToUser(systemNotification);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
            systemNotificationDao.deleteByUser(userId);
    }

}
