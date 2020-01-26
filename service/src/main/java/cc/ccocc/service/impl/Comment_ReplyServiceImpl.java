package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_Comment_ReplyDao;
import cc.ccocc.pojo.Reply;
import cc.ccocc.service.IComment_ReplyService;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public Boolean insertCommentReply(Reply reply) {
        return replyDao.insertCommentReply(reply) > 0;
    }
}
