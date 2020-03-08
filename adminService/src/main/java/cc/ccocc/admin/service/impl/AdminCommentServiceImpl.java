package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.*;
import cc.ccocc.dao.IArticle_CommentDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Comment;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 15:02  26/01/2020
 * Description:
 * 评论服务实现类
 *
 * @author Weleness
 */
@Service("adminCommentService")
public class AdminCommentServiceImpl implements IAdminCommentService {

    @Autowired
    private IArticle_CommentDao commentDao;

    @Autowired
    @Qualifier("adminComment_ReplyService")
    private IAdminComment_ReplyService adminComment_replyService;

    @Autowired
    @Qualifier("adminUser_commentService")
    private IAdminUser_CommentService adminUser_commentService;

    @Override
    public Integer getAllCommentCount() {
        return commentDao.getAllCommentCount();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        commentDao.deleteByUser(userId);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteByArticle(Long articleId) {
        commentDao.deleteByArticleId(articleId);
    }

    @Override
    public List<Comment> findByArticleId(Long articleId) {
        return commentDao.findAllCommentByArticleId(articleId);
    }


    @Override
    public AdminDTO<List<Comment>> findAll(Integer pageNo, Integer pageSize) {
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(), null, commentDao.findAll(pageNo, pageSize), getAllCommentCount(), true);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteComments(Long[] commentIds) {
        AdminDTO result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "删除成功", null,null, true);
        for (Long commentId : commentIds) {
            if(commentDao.deleteByCommentId(commentId) < 1) {
                result.setCode(ResultCode.SERVER_ERROR_CODE.getCode());
                result.setMessage("服务器异常");
                result.setStatus(false);
                break;
            }
        }
        return result;
    }


}
