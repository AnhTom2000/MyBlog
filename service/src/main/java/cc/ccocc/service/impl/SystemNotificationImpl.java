package cc.ccocc.service.impl;

import cc.ccocc.dao.ISystemNotificationDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.SystemNotificationDTO;
import cc.ccocc.pojo.SystemNotification;
import cc.ccocc.service.ISystemNotificationService;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22:39  09/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("systemNotice")
public class SystemNotificationImpl implements ISystemNotificationService {

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
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addSystemNotice(Long userId, Long sourceId, String type, String messageContent, String messageTitle) {
        SystemNotification systemNotification = SystemNotification.builder().
                systemNotificationId(SYSTEMIC_GENERATOR.generateId()).
                userId(userId).sourceId(sourceId).type(type).
                messageContent(messageContent).messageTitle(messageTitle).build();

        return systemNotificationDao.addSystemNotificationToUser(systemNotification);
    }

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  <p>更新已读状态</p>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO updateMarkReadStatus(Long userId) {
        return (systemNotificationDao.updateMarkReadStatus(userId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "操作成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  <p>删除全部的系统通知</p>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteAllSystemNotice(Long userId) {
        return (systemNotificationDao.deleteAllCommemtNotice(userId) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "操作成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

    /**
     * @param userId 用户主键
     * @Method
     * Description:
     *  <p>获取用户全部的系统通知</p>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<SystemNotificationDTO> findSystemNoticeByUserId(Long userId) {
        List<SystemNotificationDTO> systemNotificationDTOList = null;
        List<SystemNotification> systemNotificationList = systemNotificationDao.findNoticeByUserId(userId);
        if (systemNotificationList != null) {
            systemNotificationDTOList = new ArrayList<>();
            BeanCopier beanCopier = BeanCopier.create(SystemNotification.class, SystemNotificationDTO.class, false);
            for (SystemNotification systemNotification : systemNotificationList) {
                SystemNotificationDTO systemNotificationDTO = new SystemNotificationDTO();
                beanCopier.copy(systemNotification, systemNotificationDTO, null);
                systemNotificationDTOList.add(systemNotificationDTO);
            }
        }
        return systemNotificationDTOList;
    }

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  <p>获取未读系统通知数量</p>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public Integer UnMarkReadCount(Long userId) {
        return systemNotificationDao.UnMarkReadCount(userId);
    }

    /**
     * @param systemNotification_id  系统通知主键
     * @Method
     * Description:
     *  删除单条系统消息通知
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteSystemNotice(Long systemNotification_id) {
        return (systemNotificationDao.deleteCommentNoticeOne(systemNotification_id) > 0) ? new ResultDTO(ResultCode.OK_CODE.getCode(), "操作成功", true) : new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", false);
    }

}
