package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_Comment_ReplyDao;
import cc.ccocc.pojo.Reply;
import cc.ccocc.service.IComment_ReplyService;
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
@Service("comment_ReplyService")
public class Comment_ReplyServiceImpl implements IComment_ReplyService {
    @Autowired
    private IArticle_Comment_ReplyDao replyDao;


    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer insertCommentReply(Reply reply) {
        replyDao.insertCommentReply(reply);
        return  reply.getReplyId();
    }
}
