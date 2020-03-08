package cc.ccocc.admin.service;

import cc.ccocc.dto.ResultDTO;

/**
 * Created on 15:01  26/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminUser_CommentService {

   public void deleteByUser(Long userId);

   public void deleteByCommentId(Long commentId);

}
