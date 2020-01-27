package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 15:01  26/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface IUser_CommentService {

    public ResultDTO checkCommentIsLikeByOneUser( Long commentId,Long user_Id);

    public ResultDTO addCommentLike( Long commentId ,  Long userId);

}
