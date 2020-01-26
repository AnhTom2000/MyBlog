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

    public ResultDTO checkCommentIsLikeByOneUser(@Param("commentId") Long commentId);

    public ResultDTO addCommentLike(@Param("commentId") Long commentId , @Param("userId") Long userId);

}
