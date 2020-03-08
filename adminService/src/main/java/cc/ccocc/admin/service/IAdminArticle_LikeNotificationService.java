package cc.ccocc.admin.service;

import cc.ccocc.dto.LikeNotificationDTO;
import cc.ccocc.dto.ResultDTO;

import java.util.List;

/**
 * Created on 20:57  07/02/2020
 * Description:
 *
 * @author Weleness
 */

public interface IAdminArticle_LikeNotificationService {

    // 查找用户所有点赞消息推送
    public List<LikeNotificationDTO> findLikeNotificationByUserId(Long authId);

    public void deleteByUser(Long userId);

}
