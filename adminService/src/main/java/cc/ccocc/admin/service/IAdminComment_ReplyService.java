package cc.ccocc.admin.service;

import cc.ccocc.pojo.Reply;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 15:00  26/01/2020
 * Description:
 * 评论回复服务接口
 * @author Weleness
 */
public interface IAdminComment_ReplyService {


    void deleteByUser(Long userId);

    public  void deleteByCommentId(Long commentId);
}
