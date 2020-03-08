package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminComment_ReplyService;
import cc.ccocc.dao.IArticle_Comment_ReplyDao;
import cc.ccocc.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15:03  26/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminComment_ReplyService")
public class AdminComment_ReplyServiceImpl implements IAdminComment_ReplyService {
    @Autowired
    private IArticle_Comment_ReplyDao replyDao;



    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        replyDao.deleteByUserId(userId);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteByCommentId(Long commentId) {
        replyDao.deleteByCommentId(commentId);
    }


}
