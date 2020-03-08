package cc.ccocc.service;

import cc.ccocc.pojo.Reply;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 15:00  26/01/2020
 * Description:
 * 评论回复服务接口
 * @author Weleness
 */
public interface IComment_ReplyService {

    Integer insertCommentReply(@Param("reply") Reply reply);
}
