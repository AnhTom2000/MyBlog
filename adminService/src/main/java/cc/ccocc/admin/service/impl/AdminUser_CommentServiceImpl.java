package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminUser_CommentService;
import cc.ccocc.dao.IUser_CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15:04  26/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminUser_commentService")
public class AdminUser_CommentServiceImpl implements IAdminUser_CommentService {

    @Autowired
    private IUser_CommentDao user_commentDao;


    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        user_commentDao.deleteByUser(userId);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteByCommentId(Long commentId) {
        user_commentDao.deleteByCommentId(commentId);
    }
}
