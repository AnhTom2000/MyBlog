package cc.ccocc.admin.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.SystemNotificationDTO;

import java.util.List;

/**
 * Created on 22:32  09/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminSystemNotificationService {

    // 添加点赞消息
    public Integer addSystemNotice(Long userId, Long sourceId, String type, String messageContent, String messageTitle);

    public Integer addSysteNoticeBad(Long userId,String type,String messageContent,String messageTitle);

    public void  deleteByUser(Long userId);
}
