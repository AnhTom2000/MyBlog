package cc.ccocc.admin.service;

import cc.ccocc.dto.CommentNotificationDTO;
import cc.ccocc.dto.ResultDTO;

import java.util.List;

/**
 * Created on 19:53  08/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminArticle_CommentNotificationService {
    // 添加点赞消息


    public List<CommentNotificationDTO> findComment_ReplyNotificationByUserId(Long authId);

    public void  deleteByUser(Long userId);
}
