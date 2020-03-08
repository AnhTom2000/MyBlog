package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.SystemNotificationDTO;

import java.util.List;

/**
 * Created on 22:32  09/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface ISystemNotificationService {

    // 添加点赞消息
    public Integer addSystemNotice(Long userId,Long sourceId,String type,String messageContent,String messageTitle);

    public ResultDTO updateMarkReadStatus(Long userId);

    public ResultDTO deleteAllSystemNotice(Long userId);

    public List<SystemNotificationDTO> findSystemNoticeByUserId (Long userId);

    public Integer UnMarkReadCount(Long userId);

    public ResultDTO deleteSystemNotice(Long systemNotification_id);
}
