package cc.ccocc.service.impl;

import cc.ccocc.dao.IUser_CommentDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IUser_CommentService;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 15:04  26/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("user_commentService")
public class User_CommentServiceImpl implements IUser_CommentService {

    @Autowired
    private IUser_CommentDao user_commentDao;

    /**
     * @param commentId 评论的id
     * @Method Description:
     * 判断用户是否点赞了该评论
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO checkCommentIsLikeByOneUser(Long commentId) {
        System.out.println(commentId);
        Long userId = user_commentDao.checkCommentIsLikeByOneUser(commentId);
        if (userId != null) {
            System.out.println("true");
            return new ResultDTO(ResultCode.OK_CODE.getCode(), "点赞过了", true);
        }
        return new ResultDTO(ResultCode.OK_CODE.getCode(), "还没点赞，可以点赞", false);
    }

    /**
     * @param userId    用户的id
     * @param commentId 评论的id
     * @Method Description:
     * 用户点赞操作
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO addCommentLike(Long commentId, Long userId) {
        if (user_commentDao.addCommentLike(commentId, userId) > 0) {
            return new ResultDTO(ResultCode.OK_CODE.getCode(), "点赞成功", true);
        }
        return new ResultDTO(ResultCode.OK_CODE.getCode(), "点赞失败，可能已经点赞过了", false);
    }
}
